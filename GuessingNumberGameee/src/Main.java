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
        // write your code here
    }

    protected static int getRightNumber(int maximumNumber, int minimumNumber){
        Random rightNumber = new Random();

        return rightNumber.nextInt(maximumNumber - minimumNumber +1) +
                minimumNumber;

    }

    protected static void guessingNumberGame(){

        do {
            while (run){

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
            }

        }
    }


}

