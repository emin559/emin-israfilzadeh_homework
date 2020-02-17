package hw02;

import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        int width = 6;
        int height = 6;
        int targetRow = (int)(Math.random() * (((width-1) - 1) + 1)) + 1;
        int targetCol = (int)(Math.random() * (((width-1) - 1) + 1)) + 1;
        int line = 0;
        int bar = 0;
        String status ="";
        String[][] square = new String[width][height];
        Scanner scanner = new Scanner(System.in);

        System.out.println("All set. Get ready to rumble!");
        System.out.println(targetRow+ " " +targetCol);

        printSquare(width, height, line, bar, targetRow, targetCol, status,  square);

        while(line !=targetRow || bar != targetCol) {
            System.out.print("Please choose line: ");
            line = scanner.nextInt();


            System.out.print("Please choose bar: ");
            bar = scanner.nextInt();

            printSquare(width, height, line, bar, targetRow, targetCol, status,  square);


        }

    }

    private static void printSquare(int width, int height, int line, int bar, int targetRow, int targetCol, String status,  String[][] square) {
        for (int cell = 0; cell < width; cell++) {
            square[0][cell] = cell + "|";
            square[cell][0] = cell + "|";
        }


        for (int row = 0; row <width ; row++) {

            for (int col = 0; col < height ; col++) {
                if (row !=0 && col !=0 && !square[line][bar].equals("*|") && !square[line][bar].equals("X|")) {
                    square[row][col] = "-|";
                }
                if (line !=0 && bar !=0) {
                    square[line][bar]="*|";
                }
                if (line == targetRow  && bar == targetCol) {
                    square[line][bar]="X|";
                    status = "You have won!";
                }
                System.out.print(square[row][col]);
            }

            System.out.println("");
        }
        System.out.print(status);

    }
}
