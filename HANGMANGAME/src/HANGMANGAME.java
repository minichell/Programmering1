public class HANGMANGAME {


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
    }
}
