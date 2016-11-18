package com.company;

import java.util.Scanner;

/**
 * Created by Lrh on 11/17/2016.
 */
public class Prompter {

    private Game mGame;

    public Prompter(Game game){
        mGame = game;
    }

    public void play(){
        while (mGame.getRemainingTries() > 0 && !mGame.isSolved()){
            displayProgress();
            promptForGuess();

        }
        if (mGame.isSolved()) {
            System.out.printf("Congratulations you won with %d tries remaining!",
                                mGame.getRemainingTries());
        } else {
            System.out.printf("You lost; the answer was %s", mGame.getAnswer());
        }
    }

    public boolean promptForGuess(){
        boolean isHit = false;
        boolean isValidGuess = false;
        while (! isValidGuess){
            System.out.println("Enter a letter: ");
            Scanner scanner = new Scanner(System.in);
            String guessAsString = scanner.nextLine();
            try {
                isHit = mGame.applyGuess(guessAsString);
                isValidGuess = true;
            } catch (IllegalArgumentException ex){
                System.out.printf("%s Please try again. \n", ex.getMessage());
            }
        }
        return isHit;
    }

    public void displayProgress(){
        System.out.printf("You have %d tries remaining; try to solve: %s\n",
                            mGame.getRemainingTries() ,
                            mGame.getCurrentProgress());
    }
}
