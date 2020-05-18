import java.util.Random;
import java.util.Scanner;

public class TESTING {
    static Scanner inputFromPlayer = new Scanner (System.in);
    public static Random random = new Random();
    public static  char [] GuessColor;
    public static char  [] PlayerGuess;

    public static void main(String[] args) {

    }


    public static void ColorGuess() {
        String[] ColorWords = {"pink", "blue", "green"};
        GuessColor = ColorWords[random.nextInt(ColorWords.length)].toCharArray();
    }

    public static void PLayerGuessSetup(){
        PlayerGuess = new char [GuessColor.length];
        for(int i = 0; i < PlayerGuess.length; i++){
            PlayerGuess[i] = '_';
        }
        System.out.println(PlayerGuess);
    }

    public static void Game(){
        System.out.println("The word u should guess is:");
        PLayerGuessSetup();
        System.out.println("The word is : " + GuessColor.length + "letters long");
    }
}

