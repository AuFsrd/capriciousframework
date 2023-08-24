package com.capriciousframework.repositories;

import com.capriciousframework.models.BaseEntity;
import org.springframework.data.repository.CrudRepository;

public interface GenericRepository<T extends BaseEntity> extends CrudRepository<T, Integer> {
}
