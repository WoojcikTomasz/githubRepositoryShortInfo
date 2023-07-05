package com.tw.githubRepositoryShortInfo.exception;

public class RepositoryNotFoundException extends RuntimeException {
    public static String MESSAGE = "GitHub repository not found";

    public RepositoryNotFoundException() {
        super(MESSAGE);
    }
}