package ru.molner.preparingforaninterview.anntotation.miniframework;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class AnnotationProcessor {

    public static void run(Class<?> source) {
        scanSingleton(source);
        scanInject(source);
    }

    private static void scanSingleton(Class<?> source) {
        System.out.println("Сканирование Singleton...");

        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Singleton.class));
        Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(source.getPackageName());
        ArrayList<String> classPaths = candidateComponents.stream()
                .map(BeanDefinition::getBeanClassName)
                .filter(Objects::nonNull)
                .collect(Collectors.toCollection(ArrayList::new));

        classPaths.forEach(s -> SingletonComponents.getInstance().addBean(s, BeanFactory.createBean(s)));

        System.out.println("Сканирование Singleton завершено");
    }

    private static void scanInject(Class<?> source) {
        System.out.println("Сканирование Inject...");

        SingletonComponents.getInstance().getBeanMap().forEach((s, o) -> {
            try {
                Class<?> clazz = Class.forName(s);
                Field[] declaredFields = clazz.getDeclaredFields();
                Arrays.stream(declaredFields).forEach(field -> {
                    if (field.isAnnotationPresent(Inject.class)) {
                        System.out.println("x");
                        field.setAccessible(true);
                        try {
                            field.set(
                                    SingletonComponents.getInstance().getBean(clazz.getName()),
                                    SingletonComponents.getInstance().getBean(field.getType().getName())
                            );
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        SingletonComponents instance = SingletonComponents.getInstance();

        System.out.println("Сканирование Inject завершено");
    }

}
