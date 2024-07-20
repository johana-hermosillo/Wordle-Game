//Johana Hermosillo Gutierrez
//CS 1101 - Introduction to Computer Science Spring 2024
//Comprehensive Lab 3
//Wordle

/*[CS1101] Comprehensive Lab 3
This work is to be done individually. It is not permitted to.
share, reproduce, or alter any part of this assignment for any
purpose. Students are not permitted to share code, upload
this assignment online in any form, or view/receive/
modifying code written by anyone else. This assignment is part.
of an academic course at The University of Texas at El Paso and
a grade will be assigned for the work produced individually by
the student.*/

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    /* This main method body should not be modified. */ 
    public static void main(String[] args) {
        /* Only use this Scanner for user input, do not create new ones via new Scanner(System.in).*/ 
        Scanner scanner = new Scanner(System.in);
        WordleGame game = startGame(scanner);
        playGame(scanner, game);
        reportGameOutcome(game);
    }

    /* Do not modify the method signature. */ 
    public static WordleGame startGame(Scanner scanner)  {
        System.out.println("Enter a puzzle number (between 0 and 2315): ");
        int puzzleNumber = scanner.nextInt();

        //Look if the input is within the valid range
        while(puzzleNumber < 0 || puzzleNumber > 2315){
            System.out.println("Please enter a valid puzzle number (0 to 2315): ");
            if(scanner.hasNextInt()){
                puzzleNumber = scanner.nextInt();
            }else{
                scanner.next();
            }
        }
        return new WordleGame(puzzleNumber);  /*------ TODO - implement and replace me -------*/ 
    }

    /* Do not modify the method signature. */ 
    public static void playGame(Scanner scanner, WordleGame game)  {
        while(!game.isGameOver()){
            System.out.println("Enter a 5 letter guess: ");
            String guess = scanner.next();

            //Look if the guess is a valid word
            while(!WordBank.checkInDictionary(guess) || guess.length() != 5){
                System.out.print("Invalid guess. Please enter a valid 5 letter word: ");
                guess = scanner.next();
            }

            game.guess(guess);
            System.out.println(game);
        }
        /*------ TODO - implement -------*/ 
        //System.out.println(game); We need to call the method by printing it.
    }

    /* Do not modify the method signature. */ 
    public static void reportGameOutcome(WordleGame game) {
        /*------ TODO - implement -------*/ 
        if(game.isGameWin()){
            System.out.println("You won!");
        }else {
            System.out.println("The answer was " + game.getAnswer());
        }
    }
}
