import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class theHangManGame {
    static Scanner input = new Scanner(System.in);//the player have able to put an input
    public static Random random = new Random();
    public static char theGuess; // the letter that the player guessed on.
    public static char[] theCorrectGuesses; // is the list where the correct answer of the player will be.
    public static char[] randomWord; //the correct randomly word.
    public static int wordLength; // is the number of the correct randomly word.
    public static int numberOfWrongGuesses; // number of wrong guesses
    public static ArrayList<Character> incorrectGuesses = new ArrayList<Character>(); // the list where the incorrect guesses of the player will be in.

    public static void main(String[] args) {
        randomWord();
        startPosition();
    }

    /**
     * A method that will choose a random word from the list by generate a random index to pick out a word.
     * wordLength is the number of the word that will randomize.
     */
    public static void randomWord() {
        String[] guesses = {"computer", "flower", "phone", "shoes", "football", "chips", "clothes"};
        randomWord = guesses[random.nextInt(guesses.length)].toCharArray();
        wordLength = randomWord.length;
        createGuesses();
    }

    /**
     * A method that create a char-Array where the correct letters of the player will be.
     * The '-' stands for unknown letter that the player will guess on.
     */
    public static void createGuesses() {
        theCorrectGuesses = new char[wordLength];
        for (int i = 0; i < theCorrectGuesses.length; i++) {
            theCorrectGuesses[i] = '-';
        }
        System.out.println(theCorrectGuesses);
    }

    /**
     * A method for make it sure that the game will not crash.
     * @returnan an in-put from the player.
     */
    public static int isNextIntValid() {
        while (true) {
            try {
                return input.nextInt();
            } catch (Exception e) {
                System.out.println("Try to write a number pls");
                input.nextLine();
                continue;
            }
        }
    }

    /**
     * This method is for giving the player information about this game.
     * The player will choose a level that he or she wants to play.
     */
    public static void startPosition() {
        System.out.println("Welcome to the HangmanGame! \n" +
                "In this game you will guess a word. \n" +
                "Pls choose a level: \n" +
                "1.Easy Level\n" +
                "2.Medium Level\n" +
                "3.Difficulty level");

        while (true) {
            int theLevel = isNextIntValid();
            if (theLevel == 1) {
                easyGame();
                break;
            } else if (theLevel == 2) {
                mediumGame();
                break;
            } else if (theLevel == 3) {
                difficultyGame();
                break;
            } else {
                System.out.println("Pls right 1 or 2 or 3 pls!");
            }
        }
    }

    /**
     * This method contains the easiest level of this game.
     * It will give information about how many wrong guesses that the player is going to have
     */
    public static void easyGame() {
        numberOfWrongGuesses = 12;
        System.out.println("You have 6 free wrong guesses before the hangman start to hang!");
        hangManGame();
    }

    /**
     * This method contains the medium level of this game.
     * It will give information about how many wrong guesses that the player is going to have
     */
    public static void mediumGame() {
        numberOfWrongGuesses = 8;
        System.out.println("You have 2 free wrong guesses before the hangman start to hang!");
        hangManGame();
    }

    /**
     *
     * This method contains the hardest level of this game.
     * It will give information about how many wrong guesses that the player is going to have.
     */
    public static void difficultyGame() {
        numberOfWrongGuesses = 6;
        System.out.println("The hangman will start hanging if you guess wrong, you will have 6 wrong guesses");
        hangManGame();
    }

    /**
     * This method checks if the input is a letter or not.
     * @return theGuess
     */
    public static char allowOnlyLetter() {
        boolean allowLetter = true;
        while (allowLetter) {
            // The while-loop runs until the input is a letter.
            theGuess = input.next().charAt(0); //Taking only the first input letter.
            String player = String.valueOf(theGuess); //returns the string representation of the char argument.
            if (!player.matches("[a-zA-Z]+")) {
                System.out.println("Pls write a letter");
            } else if (player.matches("[a-zA-Z]+")) {
                allowLetter = false;
            }
        }
        return theGuess;
    }

    /**
     * Method that the player will get information about how many letters that the word has.
     * The player will able to guess a letter.
     *
     */
    public static void hangManGame() {
        System.out.println("The word is:");
        randomWord();
        System.out.println("The letter is " + wordLength + " long");
        boolean guessedWord = false;
        while (!guessedWord && numberOfWrongGuesses != 0) {
            System.out.println("Guess a letter");
            theGuess = allowOnlyLetter();
            isTheLetterCorrect();
            guessedWord = ifTheWordIsGuessed();
            System.out.println("The word: " + Arrays.toString(theCorrectGuesses));
            System.out.println("Your wrong guesses: " + incorrectGuesses);
            System.out.println("You have " + numberOfWrongGuesses + " guesses left.");
        }
        if (numberOfWrongGuesses == 0 || guessedWord != true) {
            System.out.println("You lost");
            System.out.println("Your wrong guesses are: " + incorrectGuesses);
            System.out.println("The word was: " + Arrays.toString(randomWord));
        }
        playAgainOrNot();
    }

    /**
     * A method that checks if the letter of the input is correct or not.
     * It will either add the correct letter in the correct list or add the wrong letter in the incorrect list, depends what the player guessed on.
     * It will also print out the hangman.
     */
    public static void isTheLetterCorrect() {
        boolean theLetterIsAlreadyGuessed = false;
        theLetterIsAlreadyGuessed = isTheLetterAlreadyGuessed();
        boolean correctInput = false;
        for (int i = 0; i < randomWord.length; i++) {
            if (randomWord[i] == theGuess) {
                System.out.println("correct guess");
                theCorrectGuesses[i] = theGuess;
                correctInput = true;
            }
        }
        if (correctInput != true && theLetterIsAlreadyGuessed !=true) {
            incorrectGuesses.add(theGuess);
            numberOfWrongGuesses--;
            printOutHangMan();
        }
    }

    /**
     * A method that checks if the letter is already guessed.
     * @return true if the player guessing a letter that has already guessed or even false if the player didn't guessed the letter before.
     */
    public static boolean isTheLetterAlreadyGuessed() {
        if (incorrectGuesses.contains(theGuess)) {
            System.out.println("You already guessed that letter, pls guess another letter!");
            return true;
        } else if (Arrays.toString(theCorrectGuesses).contains(Character.toString(theGuess))) {
            System.out.println("You already guessed that correct letter, pls guess another letter!");
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * A method that checks if the word is guessed by checking if there are any '-' in the list.
     * @return either false or true depends on the answer.
     */
    public static boolean ifTheWordIsGuessed() {
        for (int i = 0; i < theCorrectGuesses.length; i++) {
            if (theCorrectGuesses[i] == '-') {
                return false;
            }
        }
        System.out.println("The word has been guessed");
        return true;
    }

    /**
     * A method that player can choose if he/she wants to play again ot not.
     */
    public static void playAgainOrNot() {
        System.out.println("Do you want to play again or not?");
        System.out.println("1.Yes\n" +
                "2.No");
        while (true) {
            int playAgain = isNextIntValid();
            if (playAgain == 1) {
                startPosition();
                break;
            } else if (playAgain == 2) {
                System.out.println("Cya later bye!");
                break;
            } else {
                System.out.println(" pls answer 1 or 2!");
            }
        }
    }

    /**
     * A method that prints out the hangman.
     */
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
        } else if (numberOfWrongGuesses == 5) {
            System.out.println("  +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "       |\n" +
                    "       |\n" +
                    "       |\n" +
                    "==========");
        } else if (numberOfWrongGuesses == 4) {
            System.out.println("  +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "   |   |\n" +
                    "       |\n" +
                    "       |\n" +
                    "==========");
        } else if (numberOfWrongGuesses == 3) {
            System.out.println("  +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "  /|   |\n" +
                    "       |\n" +
                    "       |\n" +
                    "==========");
        } else if (numberOfWrongGuesses == 2) {
            System.out.println("The hangman is on..");
            System.out.println("  +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "  /|\\ |\n" +
                    "       |\n" +
                    "       |\n" +
                    "===========");
        } else if (numberOfWrongGuesses == 1) {
            System.out.println("  +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "  /|\\ |\n" +
                    "  /    |\n" +
                    "       |\n" +
                    "==========");
        } else if (numberOfWrongGuesses == 0) {
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
