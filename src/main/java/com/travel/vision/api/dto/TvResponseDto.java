package com.travel.vision.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TvResponseDto<T> {
    private boolean result;
    private T data;
    private String errorMessage;
    private int errorCode;
    public boolean isResult() {
        return result;
    }
}
