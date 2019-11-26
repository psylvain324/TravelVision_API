package com.travel.vision.api.dto.restaurants;

import com.travel.vision.api.enums.DocumentType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class FoodImagePost {
    @ApiModelProperty(required = true,value = "base 64 of images")
    @NotEmpty
    private String data;

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
}
