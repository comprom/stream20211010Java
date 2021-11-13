package com.lesson6;

public class Cat extends Animal {

    private static int counterCatInstance;

    static {
        maxDistanceToRun = 200;
        maxDistanceToSwim = 0;
        counterCatInstance = 0;
    }

    public Cat(String name) {
        super(name);
        counterCatInstance++;
    }

    public static int getCounterInstance() {
        return counterCatInstance;
    }

    @Override
    protected void swim(int distance) {
        System.out.println("Коты не умеют плавать. ");
    }
}
