package com.example.kristalai.pojo;

import java.io.Serializable;

public class BaseResponse implements Serializable {

    public Boolean success;
    public String message;

    public BaseResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
