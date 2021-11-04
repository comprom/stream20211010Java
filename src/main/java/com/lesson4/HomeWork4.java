package com.lesson4;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 30.10.2021
 */

public class HomeWork4 {

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static boolean isNewGame = true;
    public static String NEW_GAME_MESSAGE = "Do you want to start a new game?  (YES=1 | NO=0) >>> ";
    public static String CONTINUE_GAME_MESSAGE = "Do you want to continue the game on the next level?  " +
                            " (YES=1 | NO=0) >>> ";

    //---Description Player
    public static char player = '☻';
    public static String namePlayer = "King Artur";
    public static final int healthNewPlayer = 100;
    public static int healthPlayer = healthNewPlayer;
    public static int strPlayer = 10;
    public static int xPosPlayer;
    public static int yPosPlayer;
    public static int choicePlayer;

    public static final int moveUpPlayer = 8;
    public static final int moveLeftPlayer = 4;
    public static final int moveRightPlayer = 6;
    public static final int moveDownPlayer = 2;

    //---Description Location
    public static char[][] location;
    public static char[][] invisibleLocation;
    public static int locWidth;
    public static int locHeight;
    public static int locMin = 3;
    public static int locMax = 6;
    public static char emptyRoom = '_';
    public static char readyRoom = '+';
    public static char defeatedEnemy = '✝';
    public static boolean isRandomStartPointPlayer = false;

    //---Description Enemy
    public static char enemy = '☠';
    public static int healthEnemy;
    public static int strEnemy;
    public static int enemyValueMin = 20;
    public static int enemyValueMax = 40;
    public static int countEnemies;

    public static void main(String[] args) {
        createLevel();
        runUserChoice();
    }

    private static void runUserChoice() {
        if (isNewGame) {
            healthPlayer = healthNewPlayer;
            userChoice(NEW_GAME_MESSAGE);
        } else {
            userChoice(CONTINUE_GAME_MESSAGE);
        }

        switch (choicePlayer) {
            case 0: System.out.println("GoodBye! Game over!");
                break;
            case 1: createLevel();
                    break;
            default: System.out.println("You entered an invalid value. " +
                    "The game will be terminated.");
                    break;
        }
    }

    private static void createLevel() {
        createLocation();
        createPlayer(isRandomStartPointPlayer);
        createEnemy();
        printLocation();

        while (true) {
            directionPlayer();
            printLocation();

            if (!isALivePlayer()) {
                System.out.println(namePlayer + " is dead!");
                isNewGame = true;
                break;
            }

            if (isReadyLocation() || (countEnemies == 0)) {
                System.out.println(namePlayer + " win!");
                isNewGame = false;
                runUserChoice();
                break;
            }
        }
    }

    private static void userChoice(String message) {
        do {
            System.out.print(message);
            choicePlayer = scanner.nextInt();
        } while(scanner == null);
    }

    public static void createLocation() {
        locWidth = myRandomValueInt(locMin, locMax);
        locHeight = myRandomValueInt(locMin, locMax);
        location = new char[locHeight][locWidth];
        invisibleLocation = new char[locHeight][locWidth];

        for (int y = 0; y < locHeight; y++) {
            for (int x = 0; x < locWidth; x++) {
                location[y][x] = emptyRoom;
                invisibleLocation[y][x] = emptyRoom;
            }
        }
        System.out.println("New location created. Size " + locWidth + "x" + locHeight);
    }

    public static void createPlayer(boolean isRandom) {
        if (isRandom) {
            xPosPlayer = myRandomValueInt(0, locWidth - 1);
            yPosPlayer = myRandomValueInt(0, locHeight - 1);
        } else {
            xPosPlayer = 0;
            yPosPlayer = 0;
        }
        location[yPosPlayer][xPosPlayer] = player;
        System.out.println(namePlayer + " has spawn in room [" + xPosPlayer + ":" + yPosPlayer + "]");

    }

    public static void createEnemy() {
        countEnemies = (locWidth + locHeight) / 2;
        healthEnemy = myRandomValueInt(enemyValueMin, enemyValueMax);
        strEnemy = myRandomValueInt(enemyValueMin, enemyValueMax);

        int xPosEnemy;
        int yPosEnemy;

        for (int i = 0; i < countEnemies; i++) {

            do {
                xPosEnemy = random.nextInt(locWidth); //[0; locWidth)
                yPosEnemy = random.nextInt(locHeight); //[0; locHeight)
            } while (!isEmptyRoom(xPosEnemy, yPosEnemy));

            invisibleLocation[yPosEnemy][xPosEnemy] = enemy;
        }
        System.out.println("Enemies has spawn. Count is " + countEnemies +
                ", HP=" + healthEnemy + ", STR=" + strEnemy);
    }

    public static void directionPlayer() {

        int currentX = xPosPlayer;
        int currentY = yPosPlayer;

        int playerMoveValue;

        do {
            System.out.print("Enter destination: (UP=" + moveUpPlayer + " | DOWN=" + moveDownPlayer +
                    " | LEFT=" + moveLeftPlayer + " | RIGHT=" + moveRightPlayer + ") >>> ");
            playerMoveValue = scanner.nextInt();

            switch (playerMoveValue) {
                case moveUpPlayer:
                    yPosPlayer -= 1;
                    break;
                case moveDownPlayer:
                    yPosPlayer += 1;
                    break;
                case moveLeftPlayer:
                    xPosPlayer -= 1;
                    break;
                case moveRightPlayer:
                    xPosPlayer += 1;
                    break;
            }

        } while (!isValidMovePlayer(currentX, currentY, xPosPlayer, yPosPlayer));

        playerNextMoveAction(currentX, currentY, xPosPlayer, yPosPlayer);

    }

    public static void playerNextMoveAction(int lastX, int lastY, int nextX, int nextY) {
        if (invisibleLocation[nextY][nextX] == enemy) {

            while (true) {
                userChoice("An enemy is found in the room. " +
                        "Do you want to fight the enemy or return to the previous room? " +
                        "  (FIGHT=1 | RETURN=0) >>> ");

                if (choicePlayer == 0) {
                    System.out.println("You are come back in previous room");
                    xPosPlayer = lastX;
                    yPosPlayer = lastY;
                    break;

                } else if (choicePlayer == 1) {

                    if (healthPlayer - strPlayer >= 0) {
                        healthPlayer -= strEnemy;

                    } else {
                        healthPlayer = 0;
                    }

                    countEnemies--;
                    System.out.println("Warning! Enemy give damage to " + namePlayer +
                            " is " + strEnemy + ". " + namePlayer + " health is " + healthPlayer);
                    System.out.println("Count enemies is " + countEnemies);
                    invisibleLocation[nextY][nextX] = defeatedEnemy;
                    break;

                } else {
                    System.out.println("Enter correct answer - (Fight=1 | Comeback=0) >>> ");
                }
            }
        }
        if (invisibleLocation[lastY][lastX] == defeatedEnemy) {
            location[lastY][lastX] = defeatedEnemy;
        } else if (invisibleLocation[lastY][lastX] == enemy) {
            location[lastY][lastX] = enemy;
        } else {
            location[lastY][lastX] = readyRoom;
        }
        location[nextY][nextX] = player;
    }

    public static boolean isValidMovePlayer(int currentX, int  currentY, int nextX, int nextY) {
        if (nextX >= 0 && nextX < locWidth && nextY >= 0 && nextY < locHeight) {
            System.out.println(namePlayer + " move to [" + nextX + ":" + nextY + "]");
            return true;
        } else {
            System.out.println("Invalid move! Try again!");
            xPosPlayer = currentX;
            yPosPlayer = currentY;
            return false;
        }
    }

    public static boolean isEmptyRoom(int x, int y) {
        return ((invisibleLocation[y][x] == emptyRoom) && (location[y][x] == emptyRoom));
    }

    public static void printLocation() {
        System.out.println("=====> LOCATION <=====");
        for (int y = 0; y < locHeight; y++) {
            for (int x = 0; x < locWidth; x++) {
                System.out.print(location[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("======================");
    }

    public static int myRandomValueInt(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static boolean isALivePlayer() {
        return healthPlayer > 0;
    }

    public static boolean isReadyLocation() {
        for (int y = 0; y < locHeight; y++) {
            for (int x = 0; x < locWidth; x++) {
                if (location[y][x] == emptyRoom) {
                    return false;
                }
            }
        }
        return true;
    }
}