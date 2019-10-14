package com.travel.vision.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import javax.persistence.Column;
import java.time.Instant;

@Getter
@Setter
@Validated
public class AuditableDto extends IdentifiableDto {
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "last_modified_date")
    private Instant lastModifiedDate;
}