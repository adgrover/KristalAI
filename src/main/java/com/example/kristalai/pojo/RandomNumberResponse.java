package com.example.kristalai.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RandomNumberResponse extends BaseResponse {

    @JsonProperty("five")
    public List<Long> fiveMinuteResponse;

    @JsonProperty("ten")
    public List<Long> tenMinuteResponse;

    @JsonProperty("thirty")
    public List<Long> thirtyMinuteResponse;


    public RandomNumberResponse(boolean success, String message) {
        this(success, message, null, null, null);
    }

    public RandomNumberResponse(boolean success, String message, List<Long> fiveMinuteResponse, List<Long> tenMinuteResponse, List<Long> thirtyMinuteResponse) {
        super(success, message);
        this.fiveMinuteResponse = fiveMinuteResponse;
        this.tenMinuteResponse = tenMinuteResponse;
        this.thirtyMinuteResponse = thirtyMinuteResponse;
    }
}
