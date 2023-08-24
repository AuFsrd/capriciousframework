package com.capriciousframework.services;

import com.capriciousframework.models.BaseEntity;

import java.util.List;

public interface CapriciousService<T extends BaseEntity> {

    /**
     * Permet de savoir si le service est d'humeur à retourner des objets.
     * @return false s'il est trop frustré pour coopérer. Pensez à la complimenter !
     */
    public Boolean isInTheMood();

    /**
     * Vous devez complimenter le service régulièrement afin qu'il oublie tout et
     * apaise ses frustrations.
     * @param compliment Ecrivez un compliment.
     */
    public void compliment(String compliment);

    public Maybe<T> getById(Integer id);

    public Maybe<List<T>> getAll();

    public Maybe<T> save(T t);

    public void delete(T t);

}
