package ru.molner.preparingforaninterview.reflection;

public class User {

    private String name;
    private String middleName;
    private String surname;
    private String email;
    private int age;
    private int salary;

    private User() {
    }

    private String write() {
        return name + " " + middleName + " " + surname + " " + email + " " + age + " " + salary;
    }

    private void addSalary(int bonus) {
        salary += salary;
    }

}
