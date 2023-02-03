package com.example.rig.service;

import com.example.rig.request.AuthenticationRequest;
import com.example.rig.request.RegisterRequest;
import com.example.rig.response.AuthenticationResponse;

public interface CustomerService {

    AuthenticationResponse register(RegisterRequest registerRequest);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
