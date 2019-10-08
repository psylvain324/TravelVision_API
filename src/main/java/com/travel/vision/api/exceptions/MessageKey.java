package com.travel.vision.api.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageKey {
    private final String name;
    private final int numTokens;

    private MessageKey(String key, int numTokens){
        this.name = key;
        this.numTokens = numTokens;
    }

    public String getName() {
        return name;
    }

    public int getNumTokens() {
        return numTokens;
    }

    public static final MessageKey entity_not_found = new MessageKey("entity_not_found",1);
    public static final MessageKey error_third_party_api = new MessageKey("error_third_party_api",0);
}
