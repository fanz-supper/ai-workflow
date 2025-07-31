package com.ai.workflow.exception;

/**
 * @title: IsTureException
 * @description:
 * @author: zhangfan
 */
public class IsTureException extends RuntimeException {

    public IsTureException(String message) {
        super(message);
    }

    public static void check(Boolean b, String msg) {

        if (b == null || b == false) {
            throw new IsTureException(msg);
        }
    }
}
