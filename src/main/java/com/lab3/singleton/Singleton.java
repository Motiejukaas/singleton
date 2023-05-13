package com.lab3.singleton;

public class Singleton {
    private static volatile Singleton instance;
    private String data;

    private Singleton(String data) {
        this.data = data;
    }

    public static Singleton getInstance(String data) {
        Singleton result = instance;
        if (instance == null) {
            synchronized (Singleton.class) {
                result = instance;
                if (result == null) {
                    result = new Singleton(data);
                }
            }
        }
        return result;
    }
}
