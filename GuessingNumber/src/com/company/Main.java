package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

        static Scanner inputFromPlayer = new Scanner(System.in);

        protected static int choosingLevel; //the level the player chose
        protected static int minimunNumber; //the lowest number
        protected static int maximumNumber; //the heighest number
        protected static int rightNumber; //the random number
        protected static int guessesLeft; //the number of guesses that player has left
        protected static int numberOfGuesses; // the number of guesses that player gets from the beginning
        protected static int guessedNumber; //that number that the player guessed
        protected static boolean run = true; //the program will run when is it true
        protected static int playAgainOrQuit; //the player choosing if he wants to play again or not

        public static void main(String[] args) {

                guessingNumberGame();
        }

        protected static void guessingNumberGame() {

                while (run) {
                        System.out.println("Welcome to guessing number game");
                        System.out.println();
                        System.out.println("On this game you have only 10 chances to guess right.\n" +
                                "If you guess right, you win the game.\n" +
                                "If you don't don't have guesses left, you lose the game.");
                        System.out.println();
                        System.out.println("Choose the level that you want to play: \n 1. Easy level\n 2. Medium level\n 3. difficulty level");
                        System.out.println();
                        System.out.println("Choose the number down below");

                }

        }

                protected static void easyLevel(){
                        System.out.flush();
                        System.out.println("You have only 10 guesses");
                        numberOfGuesses = 10;
                        System.out.println("You are going to guess between 0-10 ");
                        minimunNumber = 0;
                        maximumNumber = 10;
                }

                protected static void MediumLevel(){
                        System.out.flush();
                        System.out.println("You have only 10 guesses");
                        numberOfGuesses = 10;
                        System.out.println("You are going to guess between 0-50");
                        minimunNumber = 0;
                        maximumNumber = 50;
                }

                protected static void difficultyLevel(){
                        System.out.flush();
                        System.out.println("You have only 10 guesses");
                        numberOfGuesses = 10;
                        System.out.println("You are going to guess between 0-100");
                        minimunNumber = 0;
                        maximumNumber = 100;
                }




        }
