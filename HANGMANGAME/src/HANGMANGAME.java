
import java.util.Scanner;
public class HANGMANGAME {

    static Scanner PlayerInput = new Scanner (System.in);
    public static int chooselevel;
    public static int chooseTheme;
    public static int numberOfGuesses;


    public static void main (String [] args){
        startPosition();
    }



    public static void startPosition (){
        System.out.println("Welcome to Hangman Game !!");
        System.out.println();
        System.out.println("You will guess a word by guessing letter. \n " +
                "Every time you guess wrong it will build pieces of the hangman. \n" +
                "If the hangman is complete, you lose the game. \n" +
                "If you guess the word right, you win the game");
        System.out.println();
    }

    public static void choosingLevel(){
        System.out.println("Choose the level that you want to play: \n" +
                "1. Easy level \n" +
                "2. Medium level \n" +
                "3. Difficulty level \n");

        while (true){
            chooselevel = IsNextIntValid();
            if(chooselevel == 1){
                easyLevel();
                break;
            } else if (chooselevel == 2) {
                mediumLevel();
                break;
            } else if(chooselevel == 3) {
                difficultyLevel();
                break;
            } else {
                System.out.println("PLs answer 1 or 2 or 3 pls!");
            }
        }
    }

    public static void easyLevel(){
        numberOfGuesses = 8;
        System.out.println("You will get 8 guesses");
    }

    public static void mediumLevel(){
        numberOfGuesses = 6;
        System.out.println("You will get 6 guesses");
    }

    public static void difficultyLevel(){
        numberOfGuesses = 4;
        System.out.println("You will get 4 guesses");
    }

    public static void choosingTheme(){
        System.out.println("Choose the theme that you want to guess: \n" +
                "1.Color \n" +
                "2.Furniture \n" +
                "3. Activities \n");

        while (true) {
            chooseTheme = IsNextIntValid();

            if(chooseTheme == 1){

                break;
            } else if (chooseTheme == 2){

                break;
            } else if (chooseTheme == 3){

                break;
            } else {
                System.out.println("Pls answer 1 or 2 or 3");
            }
        }
    }



    public static int IsNextIntValid (){
        while (true){
            try {
                return PlayerInput.nextInt();
            }catch (Exception e){
                System.out.println("Try to write a number pls!");
                PlayerInput.nextLine();
                continue;
            }
        }
    }
}
