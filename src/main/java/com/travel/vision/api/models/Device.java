package com.travel.vision.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "device")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Device extends BaseModel {
    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "app_version")
    private String appVersion;

    @Column(name = "os_version")
    private String osVersion;

    @Column(name = "os_type")
    private String osType;
}