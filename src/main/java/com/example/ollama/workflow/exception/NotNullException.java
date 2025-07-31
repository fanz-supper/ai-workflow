package com.example.ollama.workflow.exception;

/**
 * @title: NotNullException
 * @description:
 * @author: zhangfan
 */
public class NotNullException extends RuntimeException {

    public NotNullException(String message) {
        super(message);
    }

    public static void check(Object o, String msg) {
        if (o == null) {
            throw new NotNullException(msg);
        }
    }
}
