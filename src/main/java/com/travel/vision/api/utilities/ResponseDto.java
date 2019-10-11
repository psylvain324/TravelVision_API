package com.travel.vision.api.utilities;

import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
public class ResponseDto<T> {
    private boolean result;
    private Map<String, T> data;
    private String errorMessage;
    private int errorCode;

    public void setResult(boolean result) {
        this.result = result;
    }

    public Map<String,T> getData() {
        return data;
    }

    public void setData(Map<String,T> data) {
        this.data = data;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}