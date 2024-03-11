package com.example.cololux.service;


import com.example.cololux.dto.request.SignInRequest;
import com.example.cololux.dto.request.SignUpRequest;
import com.example.cololux.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {

    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}
