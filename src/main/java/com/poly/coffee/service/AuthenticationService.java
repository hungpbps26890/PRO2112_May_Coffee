package com.poly.coffee.service;

import com.nimbusds.jose.JOSEException;
import com.poly.coffee.dto.request.AuthenticationRequest;
import com.poly.coffee.dto.request.IntrospectRequest;
import com.poly.coffee.dto.response.AuthenticationResponse;
import com.poly.coffee.dto.response.IntrospectResponse;

import java.text.ParseException;


public interface AuthenticationService {
    public AuthenticationResponse authenticate(AuthenticationRequest request);
    public IntrospectResponse introspectResponse(IntrospectRequest request) throws JOSEException, ParseException;
}
