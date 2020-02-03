package com.travel.vision.api.services;

public interface SecurityService {
    String createToken(String subject, long ttlMillis);
    String getSubject(String token);
}
