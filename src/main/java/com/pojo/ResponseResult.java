package com.pojo;

import lombok.Data;

//前后端交互类
@Data
public class ResponseResult {
    private Integer code;
    private String message;
    private Object data;

    public ResponseResult() {
    }

    public ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
