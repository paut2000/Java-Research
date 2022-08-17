package ru.molner.preparingforaninterview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.molner.preparingforaninterview.reflection.User;
import ru.molner.preparingforaninterview.reflection.UserReflection;

import java.lang.reflect.Field;

@SpringBootApplication
public class PreparingForAnInterviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(PreparingForAnInterviewApplication.class, args);
    }


}
