package ru.molner.preparingforaninterview.anntotation.model;

import ru.molner.preparingforaninterview.anntotation.miniframework.Inject;
import ru.molner.preparingforaninterview.anntotation.miniframework.Singleton;

@Singleton
public class House {

    @Inject
    private Person person;

    private String address;

    public House() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
