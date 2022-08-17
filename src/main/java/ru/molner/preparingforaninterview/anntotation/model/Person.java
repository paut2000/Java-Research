package ru.molner.preparingforaninterview.anntotation.model;

import ru.molner.preparingforaninterview.anntotation.miniframework.Singleton;

@Singleton
public class Person {

    private String name;
    private String surname;
    private int height;

    public Person() {
    }

    public Person(String name, String surname, int height) {
        this.name = name;
        this.surname = surname;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
