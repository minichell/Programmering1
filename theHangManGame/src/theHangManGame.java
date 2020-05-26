import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class theHangManGame {
    static Scanner input = new Scanner(System.in);
    public static Random random = new Random();
    public static char theGuess;
    public static char[] theCorrectGuesses;
    public static char[] randomWord;
    public static int wordLength;
    public static int numberOfWrongGuesses;
    public static ArrayList<Character> incorrectGuesses = new ArrayList<Character>();

    public static void main(String[] args){
        randomWord();
        startPosition();

    }

    public static void randomWord(){
        String [] guesses = {"computer" , "flower" , "phone" , "shoes" , "football" , "chips" , "clothes"};
        randomWord = guesses[random.nextInt(guesses.length)].toCharArray();
        wordLength = randomWord.length;
        createGuesses();
    }

    public static void createGuesses(){
        theCorrectGuesses = new char[wordLength];
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
        hangManGame();
    }

    public static char allowOnlyLetter(){
        boolean allowLetter = true;
        while (allowLetter){
            theGuess = input.next().charAt(0);
            String player = String.valueOf(theGuess);
            if(player.length() > 1){
                System.out.println("Pls write only one letter");
            } else if(!player.matches("[a-zA-Z]+")){
                System.out.println("Pls write a letter");
            } else if(player.matches("[a-zA-Z]+")){
                allowLetter = false;
            }
        }
        return theGuess;
    }


    public static void hangManGame(){
        System.out.println("The word is:");
        randomWord();
        System.out.println("The letter is " + wordLength + " long");

        boolean guessedWord = false;
        while(!guessedWord && numberOfWrongGuesses !=0){
            System.out.println("Guess a letter");
            theGuess = allowOnlyLetter();
            isTheLetterCorrect();
            guessedWord = ifTheWordIsGuessed();
            System.out.println("The word: " + Arrays.toString(theCorrectGuesses));
            System.out.println("Your wrong guesses: " + incorrectGuesses);
        }
        if(numberOfWrongGuesses==0 || guessedWord!= true) {
            System.out.println("You lost");
            System.out.println("Your wrong guesses are: " + incorrectGuesses);
            System.out.println("The word was: " + Arrays.toString(randomWord));
        }
        playAgainOrNot();
    }

    public static void isTheLetterCorrect(){
        boolean correctInput = false;
        for(int i = 0; i < randomWord.length ; i++){
            if (randomWord[i] == theGuess) {
                System.out.println("correct guess");
                theCorrectGuesses[i] = theGuess;
                correctInput = true;
            }
        }
        if (correctInput!= true) {
            incorrectGuesses.add(theGuess);
            numberOfWrongGuesses--;
            printOutHangMan();
        }
    }

    public static boolean ifTheWordIsGuessed(){
        for (int i = 0; i < theCorrectGuesses.length; i++) {
            if (theCorrectGuesses[i] == '-') {
                return false;
            }
        }
        System.out.println("The word has been guessed");
        return true;
        }

        public static void playAgainOrNot(){
            System.out.println("Do you want to play again or not?");
            System.out.println("1.Yes\n" +
                                "2.No");
            while (true){
                int playAgain = isNextIntValid();
                if(playAgain == 1){
                    startPosition();
                    break;
                } else if (playAgain == 2){
                    System.out.println("Cya later bye!");
                    break;
                } else {
                    System.out.println(" pls answer 1 or 2!");
                }
            }
        }



    public static void printOutHangMan() {
        if (numberOfWrongGuesses == 6) {
            System.out.println("The hangman is hanging!");
            System.out.println("  +---+\n" +
                    "   |  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========");
        }
        else if(numberOfWrongGuesses == 5) {
            System.out.println("  +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "       |\n" +
                    "       |\n" +
                    "       |\n" +
                    "==========");
        }
        else if(numberOfWrongGuesses == 4) {
            System.out.println("  +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "   |   |\n" +
                    "       |\n" +
                    "       |\n" +
                    "==========");
        }
        else if(numberOfWrongGuesses == 3) {
            System.out.println("  +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "  /|   |\n" +
                    "       |\n" +
                    "       |\n" +
                    "==========");
        }
        else if(numberOfWrongGuesses == 2) {
            System.out.println("The hangman is on..");
            System.out.println("  +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "  /|\\ |\n" +
                    "       |\n" +
                    "       |\n" +
                    "===========");
        }
        else if(numberOfWrongGuesses == 1) {
            System.out.println("  +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "  /|\\ |\n" +
                    "  /    |\n" +
                    "       |\n" +
                    "==========");
        }
        else if(numberOfWrongGuesses == 0) {
            System.out.println("  +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "  /|\\ |\n" +
                    "  / \\ |\n" +
                    "       |\n" +
                    "==========");
        }
    }

}
