package com.lesson6;

public class AppRunner {
    public static void main(String[] args) {
        Cat cat = new Cat("Матроскин");
        Dog dog = new Dog("Шарик");

        cat.run(100);
        cat.swim(5);

        dog.run(600);
        dog.swim(20);

        System.out.println("Всего зверей: " + Animal.getCounterInstance());
        System.out.println("Всего котов: " + Cat.getCounterInstance());
        System.out.println("Всего собак: " + Dog.getCounterInstance());
    }
}
