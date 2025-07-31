package com.example.ollama.manager.exception;

/**
 * @title: SystemException
 * @description:
 * @author: zhangfan
 */
public class SystemException extends RuntimeException {

    public SystemException() {
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
