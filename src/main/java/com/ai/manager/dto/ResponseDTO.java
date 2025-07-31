package com.ai.manager.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @title: ResponseDTO
 * @description:
 * @author: zhangfan
 */

@Getter
@Setter
public class ResponseDTO<T> {

    private String code;
    private String message;
    T result;


    public static ResponseDTO ok() {

        ResponseDTO dto = new ResponseDTO<>();
        dto.code = "200";
        dto.message = "成功";

        return dto;
    }

    public static <U> ResponseDTO ok(U u) {

        ResponseDTO<U> dto = new ResponseDTO<>();
        dto.result = u;
        dto.code = "200";
        dto.message = "成功";

        return dto;
    }
}
