package com.capriciousframework.services;

import com.capriciousframework.models.BaseEntity;

import java.util.List;


/**
 * Le service capricieux fournit des méthodes CRUD basiques. Pour l'utiliser, il suffit de faire hériter une classe
 * de ce service en lui passant le type de l'entité souhaitée.
 * Attention, il est capricieux. Si vous lui en demandez trop, il risque de ne pas se comporter comme prévu.
 * Demandez poliment et pensez à dire merci !
 * @param <T>
 */
public interface CapriciousService<T extends BaseEntity> {

    /**
     * Permet de savoir si le service est d'humeur à retourner des objets.
     * @return false s'il est trop frustré pour coopérer. Pensez à le complimenter !
     */
    Boolean isInTheMood();

    /**
     * Le service adore les compliments. Vous pouvez complimenter le service régulièrement afin qu'il oublie tout
     * et apaise ses frustrations.
     * @param compliment Ecrivez un compliment.
     */
    String compliment(String compliment);

    /**
     * Il est conseillé de remercier le service après chaque utilisation.
     */
    void thankyou();

    /**
     * Le service déteste les ordres. Pour accéder à ses méthodes, il faut d'abord
     * le lui demander poliment.
     * @return une classe interne contenant les méthodes
     */
    MethodProvider<T> couldyou();

    /**
     * Cette classe interne fournit toutes les méthodes CRUD du service. Ces méthodes ne sont accessibles qu'en
     * demandant poliment via la méthode couldyou(). Attention, le service se souviendra de chaque demande que
     * vous lui faites, pensez donc à le remercier et le complimenter régulièrement.
     */
    interface MethodProvider<T extends BaseEntity> {
        Maybe<T> getById(Integer id);
        Maybe<List<T>> getAll();
        Maybe<T> save(T t);
        void delete(T t);
    }
}
