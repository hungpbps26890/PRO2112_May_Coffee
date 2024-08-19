package com.poly.coffee.controller;

import com.poly.coffee.constant.Constant;
import com.poly.coffee.constant.StatusCode;
import com.poly.coffee.dto.request.PaymentMethodBankRequest;
import com.poly.coffee.dto.request.UpdateOrderStatusRequest;
import com.poly.coffee.dto.response.*;
import com.poly.coffee.entity.*;
import com.poly.coffee.mapper.UserMapper;
import com.poly.coffee.repository.BankRepository;
import com.poly.coffee.repository.OrderRepository;
import com.poly.coffee.repository.PaymentMethodRepository;
import com.poly.coffee.service.MailService;
import com.poly.coffee.service.OrderService;
import com.poly.coffee.service.PaymentMethodBankService;
import com.poly.coffee.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    PaymentService paymentService;
    OrderService orderService;
    PaymentMethodBankService paymentMethodBankService;
    PaymentMethodRepository paymentMethodRepository;
    BankRepository bankRepository;
    OrderRepository orderRepository;

    UserMapper userMapper;

    MailService mailService;


    @GetMapping("/vn-pay")
    public ApiResponse<VNPayResponse> pay(HttpServletRequest request) {
        return ApiResponse.<VNPayResponse>builder()
                .code(StatusCode.SUCCESS_CODE)
                .message("VNPay Payment Process Successfully")
                .result(paymentService.createVNPayPayment(request))
                .build();
    }

    @GetMapping("/vn-pay-callback")
    public void payCallbackHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String status = request.getParameter("vnp_ResponseCode");
        long orderId = Integer.parseInt(request.getParameter("orderId"));

        OrderResponse orderResponse = orderService.getOrderById(orderId);
        UserResponse userResponse = orderResponse.getUser();
        User user = userMapper.userResponseToUser(userResponse);

        if (status.equals("00")) {
            UpdateOrderStatusRequest updateOrderStatusRequest = UpdateOrderStatusRequest.builder()
                    .id(orderId)
                    .orderStatus(OrderStatus.builder().id(1L).build())
                    .paymentStatus(true).build();
            orderService.updateOrderStatus(updateOrderStatusRequest);

            //Handle PaymentMethodBank
            Long transactionNo = Long.parseLong(request.getParameter("vnp_TransactionNo"));
            Double amount = Double.parseDouble(request.getParameter("vnp_Amount")) / 100;
            String cardType = request.getParameter("vnp_CardType");
            String bankTranNo = request.getParameter("vnp_BankTranNo");
            String bankCode = request.getParameter("vnp_BankCode");
            String orderInfo = request.getParameter("vnp_OrderInfo");
            LocalDateTime payDate = handleVnpPayDate(request.getParameter("vnp_PayDate"));

            PaymentMethodBankRequest paymentMethodBank = new PaymentMethodBankRequest();
            paymentMethodBank.setTransactionNo(transactionNo);
            paymentMethodBank.setAmount(amount);
            paymentMethodBank.setPayDate(payDate);
            paymentMethodBank.setCardType(cardType);
            paymentMethodBank.setBankTranNo(bankTranNo);
            if (bankCode.equals("NCB"))
                paymentMethodBank.setPaymentMethodId(13);
            paymentMethodBank.setBankId(12);
            paymentMethodBank.setOrderId(orderId);

            paymentMethodBankService.create(paymentMethodBank);
            //End region

            // Send Confirm Payment Email
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formattedDate = formatter.format(payDate);

            Map<String, Object> items = new HashMap<>();
            items.put(Constant.EmailTemplateData.TRANSACTION_NO_KEY, transactionNo);
            items.put(Constant.EmailTemplateData.BANK_CODE_KEY, bankCode);
            items.put(Constant.EmailTemplateData.AMOUNT_KEY, amount);
            items.put(Constant.EmailTemplateData.ORDER_INFO_KEY, orderInfo);
            items.put(Constant.EmailTemplateData.PAY_DATE_KEY, formattedDate);

            mailService.sendConfirmPayment(user, items);

            response.sendRedirect("http://localhost:3000/order");
        } else {
            response.sendRedirect("http://localhost:3000/order");
        }
    }

    private LocalDateTime handleVnpPayDate(String vnpPayDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime localDateTime = LocalDateTime.parse(vnpPayDate, formatter);
        return localDateTime;
    }
}
