package hangman;

import java.util.Scanner;

/**
 *
 * @author jmh463
 */
public class Hangman
{
    public static void main(String[] args)
    {
        String guess=""; //the letter player 2 guesses
        String currentGuess= ""; //the word that updates after a correct guess
        int fails = 0; //count for the number of failed guesses
        
        //Player 1 enters a word to be guessed
        Scanner input = new Scanner(System.in);
        System.out.println("Player 1, choose word:");
        String word = input.next();
        
        //Place spaces so player 2 cannot see the word
        for(int i = 0; i < 50; i++) System.out.println();
        
        //Print dashes to represent the number of letters in the word
        for(int i = 0; i < word.length(); i++)
        {
            currentGuess = currentGuess + "-";
        }
        System.out.println("Word to guess: " + currentGuess);
        
        //Check the number of attempts left
        while(fails != 6)
        {
            //Player 2 enters a letter
            System.out.println("Player 2, guess a letter:");
            guess = input.next();
            for(int i = 0; i < word.length(); i++)
            {
                //Check if the letter is in the original word
                if(guess.charAt(0) == word.charAt(i))
                {
                    //Update the dashed lines with correct letters if so
                    currentGuess = currentGuess.substring(0, i) + guess + currentGuess.substring(i+1, currentGuess.length());
                }
            }
            
            //Notify player 2 that the guess is correct or not and print the guess
            if(word.contains(guess))
            {
                System.out.printf("Correct guess. There are %s tries left.\n", 6 - fails);
                System.out.println(currentGuess);
            }
            else
            {
                fails++;
                System.out.printf("The word does not have that letter. " + "There are %s tries left. \n", 6 - fails);
                System.out.println(currentGuess);
            }
            
            //If the guessed word equals the original, the game is won
            if(word.contentEquals(currentGuess))
            {
                System.out.println("The word is now complete. Player 2 won the game.");
                System.exit(0);
            }
        }
        //Game lost if player 2 fails 6 times
        System.out.println("You lost the game.");
    }    
}