import java.util.Random;
import java.util.Scanner;

public class TheHangManGame {
   public static char[] guesses;
    public static Random random = new Random();
    static Scanner scanner = new Scanner (System.in);
    public static int chooseLevel;
    public static int numberOfGuesses;
    public static int chooseTheme;

    public static void main(String[] args) {
        startPosition();
    }



    public static
    public static void startPosition(){
        System.out.println(" Welcome to Hangman Game!");
        System.out.println();
        System.out.println("You will guess a word by guessing letter. \n" +
                "Every time you guess wrong it will build pieces of the hangman. \n" +
                "If the hangman is complete, you lose the game. \n" +
                "If you guess the word right, you win the game" );
        System.out.println();
        choosingLevel();
    }

    public static void choosingLevel(){
        System.out.println("Choose the level that you want to play: \n" +
                "1. Easy Level \n" +
                "2. Medium Level \n" +
                "3. Difficulty Level");
        while (true){

            if(chooseLevel == 1){
                EasyLevel();
                break;
            } else if (chooseLevel == 2){
                MediumLevel();
                break;
            } else if (chooseLevel == 3){
                DiffcultyLevel();
                break;
            } else {
                System.out.println("Answer 1 or 2 or 3");
            }
        }
    }

    public static void EasyLevel(){
        numberOfGuesses = 8;
        System.out.println("You will get 8 guesses");
    }

    public static void MediumLevel () {
        numberOfGuesses = 6;
        System.out.println("You will get 6 guesses");
    }

    public static void DiffcultyLevel(){
        numberOfGuesses = 4;
        System.out.println("You will get 4 guesses");
    }

    public static void ChooseTheTheme(){
        System.out.println("Choose the theme that you want to guess: \n" +
                "1. Color\n" +
                "2. Furniture\n" +
                "3  Activities");

        while (true){

            if (chooseTheme == 1){
                TheGame();
                break;
            }
        }
    }

    public static void TheGame(){
        String [] guesses = {"blue" , "red" , "pink"};
        boolean wePlaying = true;

        while (wePlaying){
            System.out.println("Welcome to hangman Game!");
            char [] randomWordToGuess = guesses[random.nextInt(guesses.length)].toCharArray();
            int amountOfGuesses = randomWordToGuess.length;
            char [] playerGuess = new char[amountOfGuesses];

            for(int i = 0; i < playerGuess.length; i++){
                playerGuess[i] = '-';
            }

            boolean wordIsGuessed = false;
            int tries = 0;
            while (!wordIsGuessed && tries !=amountOfGuesses){
                System.out.println("Current guesses:");
                printArray(playerGuess);
                System.out.println("Good luck and keep Guessing :D");
                char input = scanner.nextLine().charAt(0);
                tries ++;

                if(input == '-'){
                    wePlaying = false;
                    wordIsGuessed = true;
                } else {
                    for ( int i = 0; i < randomWordToGuess.length;i++){
                        if(randomWordToGuess [i] == input){
                            playerGuess[i] = input;
                        }
                    }
                    if(isTheWordGuessed(playerGuess)){
                        wordIsGuessed = true;
                        System.out.println("Congrats");
                    }
                }
            }

            if(!wordIsGuessed) System.out.println("You lost!");
            System.out.println("Wanna play again?");
            String anotherGame = scanner.nextLine();
            if(anotherGame.equals("no")) wePlaying = false;
        }
        System.out.println("Game over");
    }

        public static void printArray(char[] array){
        for ( int i = 0; i < array.length; i++){
            System.out.println(array[i] + " ");
        }
            System.out.println();
    }

        public static boolean isTheWordGuessed (char[] array){
            for (int i = 0; i < array.length; i++){
                System.out.println(array[i] + " ");
                if (array[i] == '-') return false;
            }
            return true;
        }

}