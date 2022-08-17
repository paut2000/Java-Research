package ru.molner.preparingforaninterview.anntotation;

import ru.molner.preparingforaninterview.anntotation.miniframework.AnnotationProcessor;
import ru.molner.preparingforaninterview.anntotation.miniframework.SingletonComponents;
import ru.molner.preparingforaninterview.anntotation.model.House;
import ru.molner.preparingforaninterview.anntotation.model.Person;

public class Main {

    public static void main(String[] args) {
        AnnotationProcessor.run(Main.class);

        Person person = (Person) SingletonComponents.getInstance().getBean(Person.class.getName());
        person.setName("Ivan");
        person.setSurname("Ivanov");

        House house = (House) SingletonComponents.getInstance().getBean(House.class.getName());
    }

}
