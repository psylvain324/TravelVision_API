package com.travel.vision.api.services;

import com.travel.vision.api.exceptions.CustomException;
import com.travel.vision.api.exceptions.MessageKey;
import okhttp3.internal.http2.ErrorCode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.function.Supplier;

public class BaseService {
    @PersistenceContext
    private EntityManager entityManager;

    private  <ENTITY> ENTITY findOne(Class<ENTITY> clazz, Supplier<ENTITY> entitySupplier) {
        ENTITY entity = entitySupplier.get();
        if(entity == null) {
            throw new CustomException(ErrorCode.INTERNAL_ERROR, MessageKey.entity_not_found, clazz.getSimpleName());
        }
        return entity;
    }
    public <ENTITY> ENTITY findOne(Class<ENTITY> clazz, long entityId) {
        return findOne(clazz,() ->  entityManager.find(clazz, entityId));
    }
    public <ENTITY,DTO> DTO findOne(Class<ENTITY> clazz, long id, java.util.function.Function<ENTITY,DTO> mapper) {
        return mapper.apply(findOne(clazz, id));
    }

}