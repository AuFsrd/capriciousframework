package com.capriciousframework.services;

public class Maybe<T> {

    private final CapriciousService service;
    private final T t;

    public Maybe(CapriciousService caller, T t) {
        this.service = caller;
        this.t = t;
    }

    public T please() {
        return service.isInTheMood() ? this.t : null;
    }
}
