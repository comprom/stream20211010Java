package com.lesson6;

public class Dog extends Animal {

    private static int counterDogInstance;

    static {
        maxDistanceToRun = 500;
        maxDistanceToSwim = 10;
        counterDogInstance = 0;
    }

    public Dog(String name) {
        super(name);
        counterDogInstance++;
    }

    public static int getCounterInstance() {
        return counterDogInstance;
    }

    public String getName() {
        return name;
    }
}
