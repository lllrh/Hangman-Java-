package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        if (args.length == 0){
            System.out.println("Please enter a word");
            System.exit(0);
        }
        Game game = new Game(args[0]);
        Prompter prompter = new Prompter(game);
        prompter.play();
    }
}
