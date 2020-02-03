package com.travel.vision.api.models.financials;

import com.travel.vision.api.models.common.Currency;
import com.travel.vision.api.models.common.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transfer")
public class Transfer {
    @Id
    @Column(name = "city")
    private String transactionId;

    @CreatedDate
    @Column(name = "city")
    private LocalDateTime transactionDate;

    @Column(name = "city")
    private LocalDateTime postDate;

    @CreatedBy
    @Column(name = "city")
    private User to;

    @Column(name = "city")
    private User from;

    @Column(name = "city")
    private Currency currency;
}