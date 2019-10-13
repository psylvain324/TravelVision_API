package com.travel.vision.api.repositories;

import com.travel.vision.api.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,String>, JpaSpecificationExecutor<Currency> {
    Currency save(Currency currency);
    Page<Currency> findAll(Pageable pageable);
}
