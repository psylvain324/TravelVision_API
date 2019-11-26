package com.travel.vision.api.models.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseImage extends BaseModel {
    private int height;
    @Column(columnDefinition = "boolean default false")
    private Boolean silhouette;

    @Column(columnDefinition="text")
    private String url;
    private int width;
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Boolean isSilhouette() {
        return silhouette;
    }

    public void setSilhouette(Boolean silhouette) {
        this.silhouette = silhouette;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
