import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner inputFromPlayer = new Scanner(System.in);

    public static int choosingLevel;
    public static int minimumNumber = 0;
    public static int maximumNumber;
    public static int rightNumber;
    public static int guessesLeft;
    public static int numberOfGuesses = 10;
    public static int guessedNumber;
    public static int playAgainOrQuit;
    public static boolean run = true;

    public static void main(String[] args){

    }

    public static int answerNum(int maximumNumber, int minimumNumber) {
        Random rightNum = new Random();

        return rightNum.nextInt(maximumNumber - minimumNumber + 1) +
                minimumNumber;

    }

    public static void


    public static void systemOfTheGame() {
        rightNumber = answerNum(maximumNumber, minimumNumber);
        for (int i = 1; i <= numberOfGuesses; i--) {
            guessedNumber = inputFromPlayer.nextInt();
            numberOfGuesses--;

            boolean correct = false;

            while(!correct)  {
            System.out.println("Guess");
            guessedNumber = inputFromPlayer.nextInt();
            if (guessedNumber == rightNumber) {
                System.out.println("Congrats!\n " +
                        "You won the game");
                System.out.println();
            }
            else if(guessedNumber < rightNumber){
                System.out.println("Sorry you guessed wrong\n" +
                        "the number is higher\n" +
                        "You have "  + numberOfGuesses +  " guesses left");
            }
            else if(guessedNumber > rightNumber){
                System.out.println("Sorry you guessed wrong\n" +
                        "the number is lower\n" +
                        "you have "  + numberOfGuesses +  " guesses left");

            }
        }
    }
    }
}
