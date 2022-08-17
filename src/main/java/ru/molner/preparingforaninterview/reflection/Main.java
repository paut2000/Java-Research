package ru.molner.preparingforaninterview.reflection;

public class Main {

    public static void main(String[] args) {
        UserReflection userReflection = new UserReflection();
        userReflection.setName("Peter");
        userReflection.setMiddleName("Ben");
        userReflection.setSurname("Parker");
        userReflection.setEmail("spidey@amazing.org");
        userReflection.setAge(15);
        userReflection.setSalary(658);

        System.out.println(userReflection.write());
        userReflection.addSalary(1000);
        System.out.println(userReflection.write());
    }

}
