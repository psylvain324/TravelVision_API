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

    public void setResult(boolean result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
