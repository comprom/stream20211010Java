package com.lesson1.homework1;

public class HomeWorkApp {
    private static final char NEW_LINE = '\n';

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    private static void printThreeWords() {
        String fruit1 = "Orange";
        String fruit2 = "Banana";
        String fruit3 = "Apple";
        System.out.println(fruit1 + NEW_LINE +
                           fruit2 + NEW_LINE +
                           fruit3 + NEW_LINE);
    }

    private static void checkSumSign() {
        int a = 0;
        int b = 1;
        System.out.println(a + b >= 0 ? "Сумма положительная" + NEW_LINE
                                      : "Сумма отрицательная" + NEW_LINE);
    }

    private static void printColor() {
        int value = 0;
        String result;
        if (value <= 0) {
            result = "Красный";
        } else if ((value > 0) && (value <= 100)) {
            result = "Желтый";
        } else {
            result = "Зеленый";
        }
        System.out.println(result + NEW_LINE);
    }

    private static void compareNumbers() {
        int a = 0;
        int b = 1;
        System.out.println(a >= b ? "a >= b" + NEW_LINE
                                  : "a < b" + NEW_LINE);
    }
}
