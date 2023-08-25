package com.capriciousframework.services;

import com.capriciousframework.models.BaseEntity;
import com.capriciousframework.repositories.GenericRepository;;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

public class CapriciousServiceImpl<T extends BaseEntity> implements CapriciousService<T> {

    private Integer callCounter = 0;

    @Autowired
    protected GenericRepository<T> repo;

    @Override
    public Boolean isInTheMood() {
        Random r = new Random();
        return (this.callCounter < r.nextInt(3, 9));
    }

    @Override
    public String compliment(String compliment) {
        this.callCounter = 0;
        return "01101101 01100101 01110010 01100011 01101001";
    }

    @Override
    public void thankyou() {
        this.callCounter--;
    }

    @Override
    public MethodProvider<T> couldyou() {
        return new MethodProviderImpl();
    }

    private class MethodProviderImpl implements MethodProvider<T> {

        CapriciousServiceImpl<T> service;

        MethodProviderImpl() {
            this.service = CapriciousServiceImpl.this;
        }

        private void remember() {
            service.callCounter++;
        }

        @Override
        public Maybe<T> getById(Integer id) {
            remember();
            return new Maybe<T>(service, service.repo.findById(id).orElseThrow());
        }

        @Override
        public Maybe<List<T>> getAll() {
            remember();
            return new Maybe<>(service, (List<T>) service.repo.findAll());
        }

        @Override
        public Maybe<T> save(T t) {
            remember();
            return new Maybe<>(service, service.repo.save(t));
        }

        @Override
        public void delete(T t) {
            remember();
            service.repo.delete(t);
        }

    }


}
