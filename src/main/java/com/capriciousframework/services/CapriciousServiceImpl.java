package com.capriciousframework.services;

import com.capriciousframework.models.BaseEntity;
import com.capriciousframework.repositories.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

public class CapriciousServiceImpl<T extends BaseEntity> implements CapriciousService<T> {

    private Integer errorCounter = 0;
    private Integer callCounter = 0;

    @Autowired
    protected GenericRepository<T> repo;

    @Override
    public Boolean isInTheMood() {
        Random r = new Random();
        return (this.errorCounter < r.nextInt(3, 5) && this.callCounter < r.nextInt(3, 5));
    }

    @Override
    public void compliment(String compliment) {
        this.errorCounter = 0;
        this.callCounter = 0;
    }

    @Override
    public Maybe<T> getById(Integer id) {
        this.callCounter++;
        return new Maybe<>(this, repo.findById(id).orElseThrow());
    }

    @Override
    public Maybe<List<T>> getAll() {
        this.callCounter++;
        return new Maybe<>(this, (List<T>) repo.findAll());
    }

    @Override
    public Maybe<T> save(T t) {
        this.callCounter++;
        return new Maybe<>(this, repo.save(t));
    }

    @Override
    public void delete(T t) {
        this.callCounter++;
        repo.delete(t);
    }
}
