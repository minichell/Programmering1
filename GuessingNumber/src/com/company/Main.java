
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

        static Scanner inputFromPlayer = new Scanner(System.in);

        protected static int choosingLevel; //the level the player chose
        protected static int theMinimumNumber; //the lowest number
        protected static int theMaximumNumber; //the max number
        protected static int theRightNumber; //the random number
        protected static int guessesLeft; //the number of guesses that player has left
        protected static int theNumberOfGuesses; // the number of guesses that player gets from the beginning
        protected static int guessedNumber; //that number that the player guessed
        protected static boolean run = true; //the program will run when is it true
        protected static int playAgainOrQuit; //the player choosing if he wants to play again or not

        public static void main(String[] args) {

                guessingNumberGame();
        }

        protected static int theRightNumber(int theMaximumNumber, int theMinimumNumber){
                Random rightNumber = new Random();

                return rightNumber.nextInt(theMaximumNumber - theMinimumNumber +1) +
                        theMinimumNumber;
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

                switch (choosingLevel){
                        case 1:
                                easyLevel();

                        case 2:
                                mediumLevel();

                        case 3:

                                difficultyLevel();

                                break;

                }

                        System.out.println("Do you want to play again?");
                        System.out.println();
                        System.out.println("Choose the number");
                        System.out.println("1.Yes");
                        System.out.println("2. No");
                        System.out.println();

                 playAgainOrQuit= inputFromPlayer.nextInt();

                 switch (playAgainOrQuit){

                         case 1;
                         break;

                         case 2;

                         run = false;
                                 System.out.println();
                                 System.out.println("Goodbye");
                 }
        }
                {
                        while (run) ;
                }
                protected static void easyLevel(){
                        System.out.flush();
                        System.out.println("You have only 10 guesses");
                        theNumberOfGuesses = 10;
                        System.out.println("You are going to guess between 0-10 ");
                        theMinimumNumber = 0;
                        theMaximumNumber = 10;

                        systemOfTheGame();
                }

                protected static void mediumLevel(){
                        System.out.flush();
                        System.out.println("You have only 10 guesses");
                        theNumberOfGuesses = 10;
                        System.out.println("You are going to guess between 0-50");
                        theMinimumNumber = 0;
                        theMaximumNumber = 50;

                        systemOfTheGame();
                }

                protected static void difficultyLevel(){
                        System.out.flush();
                        System.out.println("You have only 10 guesses");
                        theNumberOfGuesses = 10;
                        System.out.println("You are going to guess between 0-100");
                        theMinimumNumber = 0;
                        theMaximumNumber = 100;

                        systemOfTheGame();
                }


        private static void systemOfTheGame() {
               System.out.println("Guess a number");
               theRightNumber = theRightNumber(theMaximumNumber, theMinimumNumber);

               for (int i = 1; <= theNumberOfGuesses; i--){

                       guessedNumber = inputFromPlayer.nextInt();
                       theNumberOfGuesses--;

                       if (guessedNumber == theRightNumber) {
                               System.out.println("Congrats!\n You won the game");
                               System.out.println();

                               break;
                       }

                       else if (theNumberOfGuesses != 0) {

                               if (guessedNumber > theRightNumber) {
                                       System.out.println("Sorry you guessed wrong\n " +
                                               "the number is lower\n" +
                                               "You have" + guessesLeft + "guesses left");

                               } else if (guessedNumber < theRightNumber) {
                                       System.out.println("Sorry you guessed wrong\n" +
                                               "the number is higher\n" +
                                               "You have" + guessesLeft + "guesses left");
                               }
                       }
                       else {
                               System.out.println(" Sorry you lost the game");

                               break;
                       }
               }
       }
}
