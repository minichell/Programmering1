
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

        static Scanner inputFromPlayer = new Scanner(System.in);

        protected static int choosingLevel;
        protected static int minimumNumber;
        protected static int maximumNumber;
        protected static int rightNumber;
        protected static int guessesLeft;
        protected static int numberOfGuesses;
        protected static int guessedNumber;
        protected static int playAgainOrQuit;
        protected static boolean run = true;


        public static void main(String[] args) {
                guessingNumberGame();
        }

        protected static int rightNumber(int maximumNumber, int minimumNumber) {
                Random rightNum = new Random();

                return rightNum.nextInt(maximumNumber - minimumNumber + 1) +
                        minimumNumber;

        }

        protected static void guessingNumberGame(){

                do {


                        while (run) {

                                System.out.println("Welcome to guessing number game!");
                                System.out.println();
                                System.out.println("On this game you have only 10 chances to guess right\n" +
                                        "If you guess right, you win the game\n" +
                                        "If you don't have any guesses left, you lose the game.");
                                System.out.println();
                                System.out.println("Choose the level that you want to play:\n " +
                                        "1. Eassy Level\n " +
                                        "2. Medium Level\n" +
                                        "3. Difficulty Level");
                                System.out.println();
                                System.out.println("Choose the number down below!");

                                switch (choosingLevel) {

                                        case 1:
                                                easyLevel();
                                                break;

                                        case 2:
                                                mediumLevel();
                                                break;

                                        case 3:
                                                difficultyLevel();
                                                break;

                                }
                                System.out.println("Do you want to play again?");
                                System.out.println();
                                System.out.println("Write he number that you want");
                                System.out.println("1.Yes");
                                System.out.println("2.No");
                                System.out.println();

                                playAgainOrQuit = inputFromPlayer.nextInt();
                                switch (playAgainOrQuit) {
                                        case 1:
                                                break;
                                        case 2:
                                                run = false;
                                                System.out.println();
                                                System.out.println("Goodbye!");
                                }
                        }
                }while (run);
        }

        protected static void easyLevel(){
                System.out.flush();
                System.out.println("You have only 10 guesses");
                int numberOfGuesses = 10;
                System.out.println("You are going to guess between 0-10");
                int minimumNumber = 0;
                int maximumNumber = 10;

                systemOfTheGame();
        }

        protected static void mediumLevel() {
                System.out.flush();
                System.out.println("You have only 10 guesses");
                int numberOfGuesses = 10;
                System.out.println("You are going to guess between 0-50");
                int minimumNumber = 0;
                int maximumNumber = 50;

                systemOfTheGame();

        }

        protected static void difficultyLevel() {
                System.out.flush();
                System.out.println("You have only 10 guesses");
                int numberOfGuesses = 10;
                System.out.println("You are going to guess between 0-100");
                int minimumNumber = 0;
                int maximumNumber = 100;

                systemOfTheGame();
        }

        private static void systemOfTheGame() {
                System.out.println("Guess a number");
                rightNumber = rightNumber(maximumNumber, minimumNumber);

                for (int i = 1; i <= numberOfGuesses; i--) {
                        guessedNumber = inputFromPlayer.nextInt();
                        numberOfGuesses--;

                        if (guessedNumber == rightNumber) {
                                System.out.println("Congrats!\n " +
                                        "You won the game");
                                System.out.println();

                                break;
                        }
                        else if (numberOfGuesses != 0) {
                                if (guessedNumber > rightNumber) {
                                        System.out.println("Sorry you guessed wrong\n" +
                                                "the number is lower\n" +
                                                "you have" + guessesLeft + "guesses left");

                                } else if (guessedNumber < rightNumber) {
                                        System.out.println("Sorry you guessed wrong\n" +
                                                "the number is higher\n" +
                                                "You have" + guessesLeft + "guesses left");

                                }
                        }
                        else{
                                System.out.println("Sorry you lost the game");

                                break;
                        }
                }
        }
}



