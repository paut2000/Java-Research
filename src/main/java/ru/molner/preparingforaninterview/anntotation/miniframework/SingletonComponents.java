package ru.molner.preparingforaninterview.anntotation.miniframework;

import java.util.HashMap;
import java.util.Map;

public class SingletonComponents {

    private static SingletonComponents instance;

    private final Map<String, Object> beanMap = new HashMap<>();

    public static SingletonComponents getInstance() {
        if (instance == null) {
            instance = new SingletonComponents();
        }
        return instance;
    }

    public Object getBean(String name) {
        return beanMap.get(name);
    }

    public void addBean(String name, Object object) {
        beanMap.put(name, object);
    }

    public final Map<String, Object> getBeanMap() {
        return beanMap;
    }

}
