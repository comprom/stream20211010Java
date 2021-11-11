package com.lesson6;

public class Animal {
    protected static int maxDistanceToRun = 1000;
    protected static int maxDistanceToSwim = 1000;
    protected String name;
    private static int counterInstance = 0;

    public Animal(String name) {
        this.name = name;
        counterInstance++;
    }

    public static int getCounterInstance() {
        return counterInstance;
    }

    public String getName() {
        return name;
    }

    protected void run(int distance) {
        if (distance <= maxDistanceToRun) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println("Из " + distance + " метров " + getName() + " смог пробежать только " + maxDistanceToRun + ".");
        }
    }

    protected void swim(int distance) {
        if (distance <= maxDistanceToRun) {
            System.out.println(getName() + " проплыл " + distance + " м.");
        } else {
            System.out.println("Из " + distance + " метров " + getName() + "проплыл только " + maxDistanceToRun + ".");
        }
    }
}
