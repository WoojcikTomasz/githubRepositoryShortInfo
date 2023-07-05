package com.tw.githubRepositoryShortInfo.exception;

public class ServiceUnavailableException extends RuntimeException {
    public static String MESSAGE = "Service is currently unavailable";

    public ServiceUnavailableException() {
        super(MESSAGE);
    }
}