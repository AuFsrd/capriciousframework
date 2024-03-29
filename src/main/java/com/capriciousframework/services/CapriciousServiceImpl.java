package com.capriciousframework.services;

import com.capriciousframework.models.BaseEntity;
import com.capriciousframework.repositories.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class CapriciousServiceImpl<T extends BaseEntity> implements CapriciousService<T> {

    private Integer callCounter = 0;
    private Boolean saidHello = false;

    @Autowired
    protected GenericRepository<T> repo;

    @Override
    public Boolean isInTheMood() {
        Random r = new Random();
        return (this.callCounter < r.nextInt(3, 9));
    }

    @Override
    public String goodMorning() {
        if (LocalDateTime.now().getHour() < 12) {
            this.saidHello = true;
        }
        return "01101000 01100101 01101100 01101100 01101111";
    }

    @Override
    public String goodAfternoon() {
        if (LocalDateTime.now().getHour() >= 12 && LocalDateTime.now().getHour() < 19) {
            this.saidHello = true;
        }
        return "01101000 01100101 01101100 01101100 01101111";
    }

    @Override
    public String goodEvening() {
        if (LocalDateTime.now().getHour() >= 18 || LocalDateTime.now().getHour() < 3) {
            this.saidHello = true;
        }
        return "01101000 01100101 01101100 01101100 01101111";
    }

    @Override
    public String compliment(String compliment) {
        this.callCounter = 0;
        return "01101101 01100101 01110010 01100011 01101001";
    }

    @Override
    public void thankYou() {
        this.callCounter--;
    }

    @Override
    public MethodProvider<T> couldYou() {
        if (this.saidHello) {
            return new MethodProviderImpl();
        }
        return null;
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
            return new Maybe<>(service, service.repo.findById(id).orElseThrow());
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
