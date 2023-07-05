package com.tw.githubRepositoryShortInfo.exception;

public class ValidationException extends RuntimeException {
    public static String MESSAGE = "User and repository should not be blank";

    public ValidationException() {
        super(MESSAGE);
    }
}