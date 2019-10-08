package com.travel.vision.api.exceptions;

import okhttp3.internal.http2.ErrorCode;

public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;
    private final MessageKey messageKey;
    private final Object[] messageTokens;

    public CustomException(ErrorCode errorCode,MessageKey messageKey, Object... messageTokens){
        assert messageKey.getNumTokens() <= 0 || messageTokens != null && messageTokens.length == messageKey.getNumTokens();
        if(messageKey.getNumTokens() > 0){
            assert messageTokens != null && messageTokens.length == messageKey.getNumTokens() ;
        }
        this.errorCode = errorCode;
        this.messageKey = messageKey;
        this.messageTokens = messageTokens;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public MessageKey getMessageKey() {
        return messageKey;
    }

    public Object[] getMessageTokens() {
        return messageTokens;
    }
}
