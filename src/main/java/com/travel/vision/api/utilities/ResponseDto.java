package com.travel.vision.api.utilities;

import java.util.Map;

public class ResponseDto<T> {
    private boolean result;
    private Map<String, T> data;
    private String errormsg;
    private int errorCode;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Map<String,T> getData() {
        return data;
    }

    public void setData(Map<String,T> data) {
        this.data = data;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}