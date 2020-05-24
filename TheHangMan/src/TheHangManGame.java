import java.util.Random;
import java.util.Scanner;

public class TheHangManGame {
   public static char[] guesses;
    public static Random random = new Random();
    static Scanner scanner= new Scanner (System.in);


    public static void main(String[] args) {
        TheGame();
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