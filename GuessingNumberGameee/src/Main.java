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


}

