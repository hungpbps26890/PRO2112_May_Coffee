package com.poly.coffee.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequest {
    private String name;
    private String address;
    private String phone;
    private String email;
    private String information;
}
