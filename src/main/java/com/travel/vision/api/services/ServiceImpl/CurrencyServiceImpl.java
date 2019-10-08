package com.travel.vision.api.services.ServiceImpl;

import com.travel.vision.api.models.Currency;
import com.travel.vision.api.repositories.CurrencyRepository;
import com.travel.vision.api.services.BaseService;
import com.travel.vision.api.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import java.util.List;

@Service
public class CurrencyServiceImpl extends BaseService implements CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public Page<Currency> getAllCurrencies(Pageable pageable) {
        return currencyRepository.findAll(pageable);
    }

    @Override
    public Currency findByCode(String code) {
        return null;
    }
}
