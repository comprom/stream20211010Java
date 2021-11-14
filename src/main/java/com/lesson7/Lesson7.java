package com.lesson7;

import java.util.Scanner;

public class Lesson7 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println("Abc");
//
//        Point point = new Point(10, 25);
//
//        System.out.println(point);

//        String stringMain = "Java Virtual!";
//
//        String string1 = "Java";
//        string1 += " Virtual!";
//
//        String string2 = scanner.nextLine();
//        String string3 = "Java Virtual!";
//
//        System.out.println("stringMain > " + stringMain);
//        System.out.println("string1 > " + string1);
//        System.out.println("string2 > " + string2);
//        System.out.println("string3 > " + string3);
//        System.out.println("***************");
//        System.out.println("stringMain = string1 " + (stringMain == string1));
//        System.out.println("stringMain = string2 " + (stringMain == string2));
//        System.out.println("stringMain = string3 " + (stringMain == string3));
//        System.out.println("***************");
//        System.out.println("stringMain equals string1 " + (stringMain.equals(string1)));
//        System.out.println("stringMain equals string2 " + (stringMain.equals(string2)));
//        System.out.println("stringMain equals string3 " + (stringMain.equals(string3)));

      String stringTest1 = "Test"; //String stringTest1 = new String("Test");
      StringBuilder stringTest2 = new StringBuilder("Test");
      StringBuffer stringBuffer = new StringBuffer("Test");

      long startTime = System.nanoTime();

        for (int i = 0; i < 70000; i++) {
            stringTest1 += i; //Test0123456...69999
        }

        float delta = System.nanoTime() - startTime;
        System.out.println("Test string1 " + delta * 0.000001f + " millisec");
        System.out.println(stringTest1);

        startTime = System.nanoTime();

        for (int i = 0; i < 70000; i++) {
            stringTest2.append(i);
        }

        delta = System.nanoTime() - startTime;
        System.out.println("Test string2 " + delta * 0.000001f + " millisec");
        System.out.println(stringTest2.toString());
        System.out.println(stringTest1.equals(stringTest2.toString()));
    }
}
