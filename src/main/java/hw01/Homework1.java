package hw01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {

        //1.Creating initial variables and instantiating scanner class
        Scanner input = new Scanner(System.in);
        int requiredNumber = (int) (Math.random()*(100)+1);
        int length = 0;
        int index = 0;
        int userInput = 0;
        int[] possibleNumbers = new int[100];

        //2.Asking user input
        System.out.println("What is your name?");
        String name = input.nextLine();
        System.out.println("Let the game begin, " + name + "!");

        //3.Entering user into lifetime loop
        while(requiredNumber != userInput) {
            userInput = input.nextInt();
            possibleNumbers[index] = userInput;
            index++;
            length++;

            //checking
            if (userInput<requiredNumber) {
                System.out.println("Your number is too small. Please, try again.");
            }
            else if(userInput>requiredNumber) {
                System.out.println("Your number is too big. Please, try again.");
            }
        }

        //4.Creating array of guessed numbers
        int[] guessedNumbers = Arrays.copyOf(possibleNumbers, length);

        //5.Sorting array in ascending order
         Arrays.sort(guessedNumbers);

         //6.Reversing array with local method below
         Reverse(guessedNumbers);

         //7.Giving output to user
        System.out.printf("Congratulations, %s!\n", name);
        System.out.println("Your numbers: "+ Arrays.toString(guessedNumbers));

    }

    //Local method for reversing array
    private static void Reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int current = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = current;
        }
    }
}
