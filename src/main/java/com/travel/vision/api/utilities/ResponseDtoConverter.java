package com.travel.vision.api.utilities;

import java.util.HashMap;
import java.util.Map;

public class ResponseDtoConverter {

    public static <T> ResponseDto<T> convert(String key, T value) {
        ResponseDto<T> dto = new ResponseDto<>();
        if(key != null) {
            Map map = new HashMap<String, T>();
            map.put(key, value);
            dto.setData(map);
        }
        else {
            dto.setData(null);
        }
        dto.setResult(value != null);
        dto.setErrorMessage("");
        dto.setErrorCode(0);
        return dto;
    }

    public static <T> ResponseDto<T> convert(String key, T value, String error) {
        ResponseDto<T> dto = convert(key, value);
        dto.setErrorMessage(error);
        dto.setErrorCode(124);
        return dto;
    }

    public static <T> ResponseDto<T> convert(String key, T value, String error, int errorCode) {
        ResponseDto<T> dto = convert(key, value);
        dto.setErrorMessage(error);
        dto.setErrorCode(errorCode);
        return dto;
    }

    public static <T> TvResponse<T> convert( T value, String error,int errorCode) {
        TvResponse<T> dto = convert(value);
        dto.setErrorMessage(error);
        dto.setErrorCode(errorCode);
        return dto;
    }
    public static <T> TvResponse<T> convert(T value) {
        TvResponse<T> dto = new TvResponse<>();
        dto.setData(value);
        dto.setResult(value != null);
        dto.setErrorMessage("");
        dto.setErrorCode(0);
        return dto;
    }
}
