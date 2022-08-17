package ru.molner.preparingforaninterview.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserReflection {

    private User user;
    private Class clazz;
    private Field name;
    private Field middleName;
    private Field surname;
    private Field email;
    private Field age;
    private Field salary;

    private Method writeMethod;
    private Method addSalaryMethod;

    public UserReflection() {
        init();
    }

    public UserReflection(
            String name,
            String middleName,
            String surname,
            String email,
            int age,
            int salary
    ) {
        init();
        this.setName(name);
        this.setMiddleName(middleName);
        this.setSurname(surname);
        this.setEmail(email);
        this.setAge(age);
        this.setSalary(salary);
    }

    private void init() {
        try {
            clazz = Class.forName(User.class.getName());
            Constructor declaredConstructor = clazz.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            user = (User) declaredConstructor.newInstance();

            name = clazz.getDeclaredField("name");
            name.setAccessible(true);
            middleName = clazz.getDeclaredField("middleName");
            middleName.setAccessible(true);
            surname = clazz.getDeclaredField("surname");
            surname.setAccessible(true);
            email = clazz.getDeclaredField("email");
            email.setAccessible(true);
            age = clazz.getDeclaredField("age");
            age.setAccessible(true);
            salary = clazz.getDeclaredField("salary");
            salary.setAccessible(true);

            writeMethod = clazz.getDeclaredMethod("write");
            writeMethod.setAccessible(true);
            addSalaryMethod = clazz.getDeclaredMethod("addSalary", int.class);
            addSalaryMethod.setAccessible(true);
        } catch (NoSuchFieldException | NoSuchMethodException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        try {
            return (String) name.get(user);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void setName(String name) {
        try {
            this.name.set(user, name);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public String getMiddleName() {
        try {
            return (String) middleName.get(user);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void setMiddleName(String middleName) {
        try {
            this.middleName.set(user, middleName);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSurname() {
        try {
            return (String) surname.get(user);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void setSurname(String surname) {
        try {
            this.surname.set(user, surname);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmail() {
        try {
            return (String) email.get(user);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void setEmail(String email) {
        try {
            this.email.set(user, email);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public int getAge() {
        try {
            return (int) age.get(user);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void setAge(int age) {
        try {
            this.age.set(user, age);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public int getSalary() {
        try {
            return (int) salary.get(user);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void setSalary(int salary) {
        try {
            this.salary.set(user, salary);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public String write() {
        try {
            return (String) writeMethod.invoke(user);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public void addSalary(int bonus) {
        try {
            addSalaryMethod.invoke(user, bonus);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}
