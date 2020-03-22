import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner inputFromPlayer = new Scanner(System.in); //the player have able to put an input

    public static int chooseLevel; //the player that player can choose between
    public static int minimumNumber = 0; //the lowest number in the interval
    public static int maximumNumber; //the highest number in the interval
    public static int rightNumber; //the right random answer
    public static int guessesLeft; //how many guesses left that player has
    public static int numberOfGuesses = 10; //the player get 10 guesses from the beginning
    public static int guessedNumber; //the number that player guessed on
    public static int playAgainOrQuit; //the player can choose to play again or not

    public static void main(String[] args) {
        guessingNumberGame();
    }

    /**
     * This is a method for the random answer
     * @param maximumNumber the highest number in the interval
     * @param minimumNumber the lowest number in the interval
     * @return the number which the player has to guess
     */
    public static int answerNum(int maximumNumber, int minimumNumber) {
        Random rightNum = new Random();

        return rightNum.nextInt(maximumNumber - minimumNumber + 1) +
                minimumNumber;

    }

    /**
     *
     * This method is for giving person information about the game
     * This will contain the whole game
     */
    public static void guessingNumberGame() {

            System.out.println("Welcome to guessing number game!");
            System.out.println();
            System.out.println("On this game you have only 10 chances to guess right\n" +
                    "If you guess right, you win the game\n" +
                    "If you don't have any guesses left, you lose the game.");
        System.out.println();
        System.out.println("Choose the level that you want to play:\n"+
                    "1.Easy Level\n"+
                    "2.Medium Level\n"+
                    "3.Difficulty Level");
            System.out.println();

            choosingLevel();
    }

    /**
     *
     * A method for makes it sure that the game will not crash
     * @return an int-input from the player
     */
    public static int isNextIntValid(){
        while (true){
            try{
                return inputFromPlayer.nextInt();
            }
            catch (Exception e){
                System.out.println("Try to write a number pls");
                inputFromPlayer.nextLine();
                continue;
            }
        }
    }

    /**
     * A method that player can choose if he wants to play again or not
     */
    public static void playingAgainOrNot() {
        System.out.println("Do you want to play again?");
        System.out.println();
        System.out.println("Write the number that you want");
        System.out.println("1.Yes\n"+"2.No");
        System.out.println();

        playAgainOrQuit = isNextIntValid();

        if (playAgainOrQuit == 1) {
                guessingNumberGame();

        } else if (playAgainOrQuit == 2) {
            System.out.println("Goodbye!");
        }
    }

    /**
     * A method that player can choose which level he wants to plat
     */
    public static void choosingLevel() {
        chooseLevel = isNextIntValid();
        if (chooseLevel == 1) {
            easyLevel();
        } else if (chooseLevel == 2) {
            mediumLevel();
        } else if (chooseLevel == 3) {
            difficultyLevel();
        }
    }

    /**
     *
     * This method contains the easiest mode of this game.
     */
    public static void easyLevel() {
        System.out.flush();
        numberOfGuesses = 10;
        System.out.println("You have only 10 guesses");
        System.out.println("You are going to guess between 0-10");
        maximumNumber = 10;
        minimumNumber = 0;

        systemOfTheGame();
    }


    public static void mediumLevel() {
        System.out.flush();
        System.out.println("You have only 10 guesses");
        numberOfGuesses = 10;
        System.out.println("You are going to guess between 0-50");
        maximumNumber = 50;

        systemOfTheGame();

    }

    public static void difficultyLevel() {
        System.out.flush();
        System.out.println("You have only 10 guesses");
        numberOfGuesses = 10;
        System.out.println("You are going to guess between 0-100");
        minimumNumber = 0;
        maximumNumber = 100;

        systemOfTheGame();
    }

    public static void systemOfTheGame() {
        rightNumber = answerNum(maximumNumber, minimumNumber);
             System.out.println("Guess a number");
        for (int i = 1; i <= numberOfGuesses; i--) {
            guessedNumber = isNextIntValid();
            numberOfGuesses--;

            if (guessedNumber == rightNumber) {
                System.out.println("Congrats!\n" +
                        "You won the game!");
                playingAgainOrNot();

            } else if (guessedNumber < rightNumber) {
                System.out.println("Sorry you guessed wrong\n" +
                        "the number is higher\n" +
                        "You have " + numberOfGuesses + " guesses left");
            } else if (guessedNumber > rightNumber) {
                System.out.println("Sorry you guessed wrong\n" +
                        "the number is lower\n" +
                        "you have " + numberOfGuesses + " guesses left");

            } if (numberOfGuesses == 0) {
                System.out.println("Sorry you lost the game");
                playingAgainOrNot();
            }

        }
    }
}
