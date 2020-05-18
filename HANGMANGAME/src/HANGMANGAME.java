
import java.util.Scanner;
public class HANGMANGAME {

    static Scanner PlayerInput = new Scanner (System.in);
    public static int chooselevel;
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
