package com.travel.vision.api.services;

import com.travel.vision.api.models.Currency;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import java.util.List;

public interface CurrencyService {
    Page<Currency> getAllCurrencies(Pageable pageable);
    Currency findByCode(String code);

}
