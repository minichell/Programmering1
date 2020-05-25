import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class theHangManGame {
    static Scanner input = new Scanner(System.in);
    public static Random random = new Random();
    public static char[] theCorrectGuesses;
    public static char[] randomWord;
    public static int wordLength;
    public static int numberOfWrongGuesses;

    public static void main(String[] args){
        startPosition();

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

    public static int isNextIntValid(){
        while (true){
            try{
                return input.nextInt();
            }
            catch (Exception e){
                System.out.println("Try to write a number pls");
                input.nextLine();
                continue;
            }
        }
    }
    public static void startPosition() {
        System.out.println("Welcome to the HangmanGame! \n" +
                "In this game you will guess a word. \n" +
                "Pls choose a level: \n" +
                "1.Easy Level\n" +
                "2.Medium Level\n" +
                "3.Difficulty level");

        while (true) {
            int theLevel = isNextIntValid();
            if(theLevel == 1){
                easyGame();
                break;
            } else if(theLevel == 2){
                mediumGame();
                break;
            } else if(theLevel == 3){
                difficultyGame();
                break;
            } else {
                System.out.println("Pls right 1 or 2 or 3 pls!");
            }
        }
    }

    public static void easyGame(){
        numberOfWrongGuesses = 12;
        System.out.println("You have 6 free wrong guesses before the hangman start to hang!");
        hangManGame();
    }

    public static void mediumGame(){
        numberOfWrongGuesses = 8;
        System.out.println("You have 2 free wrong guesses before the hangman start to hang!");
    }

    public static void difficultyGame(){
        numberOfWrongGuesses = 6;
        System.out.println("The hangman will start hanging if you guess wrong");
    }

    public static void hangManGame(){
        System.out.println("The word is:");
        randomWord();
    }
}
