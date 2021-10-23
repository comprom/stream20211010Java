package com.lesson1.homework1;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
        System.out.println();
    }

    private static void checkSumSign() {
        int a = 0;
        int b = 1;
        System.out.println(a + b >= 0 ? "Сумма положительная" : "Сумма отрицательная");
        System.out.println();
    }

    private static void printColor() {
        int value = 0;
        String result;
        if (value <= 0) {
            result = "Красный";
        } else {
            result = (value > 0 && value <= 100 ? "Желтый" : "Зеленый");
        }
        System.out.println(result);
        System.out.println();
    }

    private static void compareNumbers() {
        int a = 0;
        int b = 1;
        System.out.println(a >= b ? "a >= b" : "a < b" );
        System.out.println();
    }
}
