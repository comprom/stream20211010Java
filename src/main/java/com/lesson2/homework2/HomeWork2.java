package com.lesson2.homework2;

public class HomeWork2 {
    public static void main(String[] args) {
        int firstNumber = 0;
        int secondNumber = 2;
        System.out.println(isSumOfNumberInARange(firstNumber, secondNumber));
        System.out.println();

        printSignOfNumber(firstNumber);
        System.out.println();

        System.out.println(isNumberNonePositive(secondNumber));
        System.out.println();

        String text = "строка";
        int amount = 5;
        printStringSpecifiedNumberOfTimes(text, amount);
        System.out.println();

        int year = 2021;
        System.out.println(isYearLeap(year));
    }

    private static boolean isSumOfNumberInARange(int firstNumber, int secondNumber) {
        return ((firstNumber + secondNumber >= 10) && (firstNumber + secondNumber <= 20));
    }

    private static void printSignOfNumber(int number) {
        System.out.println(number < 0 ? number + " - отрицательное число" : number + " - положительное число");
    }

    private static boolean isNumberNonePositive(int number) {
        return (number < 0);
    }

    private static void printStringSpecifiedNumberOfTimes(String inputString, int number) {
        if (number > 0) {
            for (int i = 0; i < number; i++) {
                System.out.println(inputString);
            }
        }
    }

    private static boolean isYearLeap(int year) {
        return ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)));
    }
}
