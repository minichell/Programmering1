import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class theHangManGame {
    Scanner input = new Scanner(System.in);
    public static Random random = new Random();
    public static char[] theCorrectGuesses;
    public static char[] randomWord;
    public static int wordLength;


    public static void main(String[] args){
        randomWord();

    }

    public static void randomWord(){
        String [] guesses = {"computer" , "flower" , "phone" , "shoes" , "football" , "chips" , "clothes"};
        char[] randomWord = guesses[random.nextInt(guesses.length)].toCharArray();
        wordLength = randomWord.length;
        createGuesses();
    }

    public static void createGuesses(){
        char[] theCorrectGuesses = new char[wordLength];
       for(int i = 0; i < theCorrectGuesses.length; i++){
           theCorrectGuesses[i] = '-';
       }
        System.out.println(theCorrectGuesses);
    }


    public static void hangManGame(){

    }
}
