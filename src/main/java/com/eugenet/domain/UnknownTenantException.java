package com.eugenet.domain;

public class UnknownTenantException extends RuntimeException {

    public UnknownTenantException(String message) {
        super(message);
    }
}
