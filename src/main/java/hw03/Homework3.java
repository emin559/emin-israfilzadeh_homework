package hw03;

import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {

        String[][] scedule = new String[7][2];
        scedule[0][0] = "Sunday";
        scedule[0][1] = "do home work";
        scedule[1][0] = "Monday";
        scedule[1][1] = "go to courses;";
        scedule[2][0] = "Tuesday";
        scedule[2][1] = "watch a film";
        scedule[3][0] = "Wednesday";
        scedule[3][1] = "go for a walk";
        scedule[4][0] = "Thursday";
        scedule[4][1] = "meet with friends";
        scedule[5][0] = "Friday";
        scedule[5][1] = "play football";
        scedule[6][0] = "Saturday";
        scedule[6][1] = "do not go out";

        Scanner input = new Scanner(System.in);

        System.out.print("Please, input the day of the week: ");

        String userInput = input.nextLine().toLowerCase().trim();
        String newTask = "";

        while(!userInput.equals("exit")) {

            switch(userInput) {
                case "sunday":
                    System.out.printf("Your tasks for %s: %s\n", scedule[0][0], scedule[0][1]);
                    System.out.print("Please, input the day of the week: ");

                    break;
                case "monday":
                    System.out.printf("Your tasks for %s: %s\n", scedule[1][0], scedule[1][1]);
                    System.out.print("Please, input the day of the week: ");

                    break;
                case "tuesday":
                    System.out.printf("Your tasks for %s: %s\n", scedule[2][0], scedule[2][1]);
                    System.out.print("Please, input the day of the week: ");

                    break;
                case "wednesday":
                    System.out.printf("Your tasks for %s: %s\n", scedule[3][0], scedule[3][1]);
                    System.out.print("Please, input the day of the week: ");

                    break;
                case "thursday":
                    System.out.printf("Your tasks for %s: %s\n", scedule[4][0], scedule[4][1]);
                    System.out.print("Please, input the day of the week: ");

                    break;
                case "friday":
                    System.out.printf("Your tasks for %s: %s\n", scedule[5][0], scedule[5][1]);
                    System.out.print("Please, input the day of the week: ");
                    break;
                case "saturday":
                    System.out.printf("Your tasks for %s: %s\n", scedule[6][0], scedule[6][1]);
                    System.out.print("Please, input the day of the week: ");
                    break;
                case "change sunday":
                case "reschedule sunday":
                    System.out.printf("Please, input new tasks for %s.\n", scedule[0][0]);
                    newTask = input.nextLine();
                    scedule[0][1] = newTask;
                    System.out.print("Please, input the day of the week: ");
                    break;
                case "change monday":
                case "reschedule monday":
                    System.out.printf("Please, input new tasks for %s.\n", scedule[1][0]);
                    newTask = input.nextLine();
                    scedule[1][1] = newTask;
                    System.out.print("Please, input the day of the week: ");
                    break;
                case "change tuesday":
                case "reschedule tuesday":
                    System.out.printf("Please, input new tasks for %s.\n", scedule[2][0]);
                    newTask = input.nextLine();
                    scedule[2][1] = newTask;
                    System.out.print("Please, input the day of the week: ");
                    break;
                case "change wednesday":
                case "reschedule wednesday":
                    System.out.printf("Please, input new tasks for %s.\n", scedule[3][0]);
                    newTask = input.nextLine();
                    scedule[3][1] = newTask;
                    System.out.print("Please, input the day of the week: ");
                    break;
                case "change thursday":
                case "reschedule thursday":
                    System.out.printf("Please, input new tasks for %s.\n", scedule[4][0]);
                    newTask = input.nextLine();
                    scedule[4][1] = newTask;
                    System.out.print("Please, input the day of the week: ");
                    break;
                case "change friday":
                case "reschedule friday":
                    System.out.printf("Please, input new tasks for %s.\n", scedule[5][0]);
                    newTask = input.nextLine();
                    scedule[5][1] = newTask;
                    System.out.print("Please, input the day of the week: ");
                    break;
                case "change saturday":
                case "reschedule saturday":
                    System.out.printf("Please, input new tasks for %s.\n", scedule[6][0]);
                    newTask = input.nextLine();
                    scedule[6][1] = newTask;
                    System.out.print("Please, input the day of the week: ");
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again.");
            }

            userInput = input.nextLine().toLowerCase().trim();

        }
    }
}