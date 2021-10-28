package com.lesson3;

import java.util.Arrays;

public class HomeWork3 {
    private static final String ERROR_MESSAGE = "Массив не отвечает условию задачи. ";
    private static final String PROCESSED_ARRAY = "Обработанный массив: ";
    private static final String SOURCE_ARRAY = "Исходный массив: ";
    private static final String TASK = "Задание ";
    private static final int ONE = 1;
    private static final int ZERO = 0;

    public static void main(String[] args) {
        int taskCounter = 1;

        //Task 1
        int[] sourceArray = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(TASK + taskCounter++);
        System.out.println(SOURCE_ARRAY);
        System.out.println(Arrays.toString(sourceArray));
        System.out.println(PROCESSED_ARRAY);
        System.out.println(Arrays.toString(changeInIntArrayZeroToOneAndOneToZero(sourceArray)));
        System.out.println();

        //Task2
        int[] sourceArrayTaskTwo = new int[100];
        System.out.println(TASK + taskCounter++);
        System.out.println(PROCESSED_ARRAY);
        System.out.println(Arrays.toString(fillIntArrayFromOneToOneHundred(sourceArrayTaskTwo)));
        System.out.println();

        //Task3
        int[] sourceArrayTaskThree = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int controlNumber = 6;
        int multiplier = 2;
        System.out.println(TASK + taskCounter++);
        System.out.println(SOURCE_ARRAY);
        System.out.println(Arrays.toString(sourceArrayTaskThree));
        System.out.println(PROCESSED_ARRAY);
        System.out.println(Arrays.toString(multiplicationByMultiplierArrayMembersThatAreLessThanControlNumber(
                sourceArrayTaskThree, controlNumber, multiplier)));
        System.out.println();

        //Task4
        int sizeOfArray = 5;
        int[][] sourceArrayTaskFour = new int[sizeOfArray][sizeOfArray];
        System.out.println(TASK + taskCounter++);
        System.out.println(PROCESSED_ARRAY);
        outputTwoDimensionalArray(fillArrayMembersOnDiagonalsWithOnes(sourceArrayTaskFour));
        System.out.println();

        //Task5
        int len = 10;
        int initialValue = 8;
        System.out.println(TASK + taskCounter++);
        System.out.println(PROCESSED_ARRAY);
        System.out.println(Arrays.toString(getOneDimensionalArrayOfLengthLenAndValuesInitialValue(len, initialValue)));
        System.out.println();

        //Task6
        int[] sourceArrayTaskSix = new int[]{2, 5, 3, 8, 0, 6, 4, 7, 9, 1};
        System.out.println(TASK + taskCounter++);
        System.out.println(SOURCE_ARRAY);
        System.out.println(Arrays.toString(sourceArrayTaskSix));
        System.out.println("Min element = " + findMinNumberInArray(sourceArrayTaskSix));
        System.out.println("Max element = " + findMaxNumberInArray(sourceArrayTaskSix));
        System.out.println();

        //Task7
        int[] sourceArrayTaskSeven = new int[]{0, 3, 1, 0, 3, 0, 0, 2, 0, 9};
        System.out.println(TASK + taskCounter);
        System.out.println(SOURCE_ARRAY);
        System.out.println(Arrays.toString(sourceArrayTaskSeven));
        System.out.println("Result: " + checkBalance(sourceArrayTaskSeven));
    }

    private static int[] changeInIntArrayZeroToOneAndOneToZero(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ZERO) {
                array[i] = ONE;
            } else if (array[i] == ONE) {
                array[i] = ZERO;
            } else {
                throw new RuntimeException(ERROR_MESSAGE);
            }
        }
        return array;
    }

    private static int[] fillIntArrayFromOneToOneHundred(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    private static int[] multiplicationByMultiplierArrayMembersThatAreLessThanControlNumber(
            int[] array, int sourceControlNumber, int sourceMultiplier) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] < sourceControlNumber) {
                array[i] = array[i] * sourceMultiplier;
            }
        }
        return array;
    }

    private static void outputTwoDimensionalArray(int[][] sourceArray) {
        for (int i = 0; i < sourceArray[0].length; i++) {
            for (int j = 0; j < sourceArray.length; j++) {
                System.out.print(sourceArray[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static int[][] fillArrayMembersOnDiagonalsWithOnes(int[][] sourceArray) {
        int one = 1;
        int arraySize = sourceArray.length;
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                if ((i == j) || (i == arraySize - j - 1)) {
                    sourceArray[i][j] = one;
                }
            }
        }
        return sourceArray;
    }

    private static int[] getOneDimensionalArrayOfLengthLenAndValuesInitialValue(int sourceLen, int sourceInitialValue) {
        int[] array = new int[sourceLen];
        for (int i = 0; i < sourceLen; i++) {
            array[i] = sourceInitialValue;
        }
        return array;
    }

    private static int findMinNumberInArray(int[] sourceArray) {
        int min = sourceArray[0];
        if (sourceArray.length > 1) {
            for (int number : sourceArray) {
                if (min > number) {
                    min = number;
                }
            }
        }
        return min;
    }

    private static int findMaxNumberInArray(int[] sourceArray) {
        int max = sourceArray[0];
        if (sourceArray.length > 1) {
            for (int number : sourceArray) {
                if (max < number) {
                    max = number;
                }
            }
        }
        return max;
    }

    private static boolean checkBalance(int[] sourceArray) {
        boolean result = false;

        for (int i = 0; i < sourceArray.length; i++) {
            int sumOfLeftPart = 0;
            int sumOfRightPart = 0;

            for (int j = 0; j < i; j++) {
                sumOfLeftPart = sumOfLeftPart + sourceArray[j];
            }

            for (int k = i; k < sourceArray.length; k++) {
                sumOfRightPart = sumOfRightPart + sourceArray[k];
            }

            if (sumOfLeftPart == sumOfRightPart) {
                result = true;
                break;
            }
        }
        return result;
    }
}