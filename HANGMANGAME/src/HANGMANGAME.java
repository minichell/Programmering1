import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class HANGMANGAME {

    static Scanner PlayerInput = new Scanner (System.in);
    public static Random random = new Random();
    public static int chooselevel;
    public static int chooseTheme;
    public static int numberOfGuesses;
    public static char [] randomColor;
    public static int varietyOfGuesses;
    public static char [] playerGuess;
    public static char TheGuess;

    public static void main (String [] args){
        startPosition();
        HangmanGame();

    }

    public static void startPosition (){
        System.out.println("Welcome to Hangman Game !!");
        System.out.println();
        System.out.println("You will guess a word by guessing letter.\n "+
                "Every time you guess wrong it will build pieces of the hangman.\n" +
                "If the hangman is complete, you lose the game.\n"+
                "If you guess the word right, you win the game");
        System.out.println();
        choosingLevel();
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
        choosingTheme();
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
                "3.Activities \n");

        while (true) {
            chooseTheme = IsNextIntValid();

            if(chooseTheme == 1){
             HangmanGame();
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


    public static void HangmanGame() {
        String[] colorWords = {"blue", "pink", "green"};

        boolean startGame = true;
        while (startGame) {
            System.out.println("Good luck");
            char[] randomColor = colorWords[random.nextInt(colorWords.length)].toCharArray();
            int varietyOfGuesses = randomColor.length;
            char[] GuessPlayer = new char[varietyOfGuesses];

            for (int i = 0; i < GuessPlayer.length; i++) {
                GuessPlayer[i] = '-';
            }

            boolean wordIsGuesses = false;

            while (!wordIsGuesses && numberOfGuesses != varietyOfGuesses) {
                System.out.println("The word is:");
                printArray(playerGuess);
                TheGuess = OnlyLetter();
                numberOfGuesses++;

                if(TheGuess == '-'){
                    startGame = false;
                    wordIsGuesses = true;
                } else {
                    for (int i = 0; i < randomColor.length; i++){
                        if(randomColor[i] == TheGuess){
                            GuessPlayer[i] = TheGuess;
                        }
                    }
                    if(IsTheWordGuessed(GuessPlayer)){
                        wordIsGuesses = true;
                        System.out.println("Congrats!");
                    }
                }
                if(!wordIsGuesses) System.out.println("no guesses left");
            }
            System.out.println("Game is over");
        }
    }

    public static void printArray(char[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array [i] + " ");
        }
        System.out.println();
    }

    public static boolean IsTheWordGuessed(char[] array){
        for(int i = 0; i < array.length; i++){
            if (array[i] == '-') return false;
        }
        return true;
    }


    public static  char OnlyLetter(){
        boolean error = true;
        while (error){

            String TheGuess = PlayerInput.next();
            if (TheGuess.length() > 1){
                System.out.println("Write only one letter pls!");
            } else if(!TheGuess.matches("[a-zA-Z]+")){
                System.out.println("Write a letter pls!");
            } else if(TheGuess.matches("[a-zA-Z]")){
                error = false;
            }
        }
        return TheGuess;
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