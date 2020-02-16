package hw03;

import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {

        //1.Creating schedule
        String[][] schedule = new String[7][2];
        schedule[0][0] = "Sunday";
        schedule[0][1] = "do home work";
        schedule[1][0] = "Monday";
        schedule[1][1] = "go to courses;";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "watch a film";
        schedule[3][0] = "Wednesday";
        schedule[3][1] = "go for a walk";
        schedule[4][0] = "Thursday";
        schedule[4][1] = "meet with friends";
        schedule[5][0] = "Friday";
        schedule[5][1] = "play football";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "do not go out";


        //2.Asking user to input command
        System.out.print("Please, input the day of the week: ");

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine().toLowerCase().trim();
        String newTask = "";

        //3.Entering user into lifetime loop
        while(!userInput.equals("exit")) {

            switch(userInput) {
                //Informative commands begin
                case "sunday":
                    System.out.printf("Your tasks for %s: %s\n", schedule[0][0], schedule[0][1]);
                    System.out.print("Please, input the day of the week: ");
                    break;

                case "monday":
                    System.out.printf("Your tasks for %s: %s\n", schedule[1][0], schedule[1][1]);
                    System.out.print("Please, input the day of the week: ");
                    break;

                case "tuesday":
                    System.out.printf("Your tasks for %s: %s\n", schedule[2][0], schedule[2][1]);
                    System.out.print("Please, input the day of the week: ");
                    break;

                case "wednesday":
                    System.out.printf("Your tasks for %s: %s\n", schedule[3][0], schedule[3][1]);
                    System.out.print("Please, input the day of the week: ");
                    break;

                case "thursday":
                    System.out.printf("Your tasks for %s: %s\n", schedule[4][0], schedule[4][1]);
                    System.out.print("Please, input the day of the week: ");
                    break;

                case "friday":
                    System.out.printf("Your tasks for %s: %s\n", schedule[5][0], schedule[5][1]);
                    System.out.print("Please, input the day of the week: ");
                    break;

                case "saturday":
                    System.out.printf("Your tasks for %s: %s\n", schedule[6][0], schedule[6][1]);
                    System.out.print("Please, input the day of the week: ");
                    break;
                    //informative commands end

                //imperative commands begin
                case "change sunday":
                case "reschedule sunday":
                    System.out.printf("Please, input new tasks for %s.\n", schedule[0][0]);
                    newTask = input.nextLine();
                    schedule[0][1] = newTask;
                    System.out.print("Please, input the day of the week: ");
                    break;

                case "change monday":
                case "reschedule monday":
                    System.out.printf("Please, input new tasks for %s.\n", schedule[1][0]);
                    newTask = input.nextLine();
                    schedule[1][1] = newTask;
                    System.out.print("Please, input the day of the week: ");
                    break;

                case "change tuesday":
                case "reschedule tuesday":
                    System.out.printf("Please, input new tasks for %s.\n", schedule[2][0]);
                    newTask = input.nextLine();
                    schedule[2][1] = newTask;
                    System.out.print("Please, input the day of the week: ");
                    break;

                case "change wednesday":
                case "reschedule wednesday":
                    System.out.printf("Please, input new tasks for %s.\n", schedule[3][0]);
                    newTask = input.nextLine();
                    schedule[3][1] = newTask;
                    System.out.print("Please, input the day of the week: ");
                    break;

                case "change thursday":
                case "reschedule thursday":
                    System.out.printf("Please, input new tasks for %s.\n", schedule[4][0]);
                    newTask = input.nextLine();
                    schedule[4][1] = newTask;
                    System.out.print("Please, input the day of the week: ");
                    break;

                case "change friday":
                case "reschedule friday":
                    System.out.printf("Please, input new tasks for %s.\n", schedule[5][0]);
                    newTask = input.nextLine();
                    schedule[5][1] = newTask;
                    System.out.print("Please, input the day of the week: ");
                    break;

                case "change saturday":
                case "reschedule saturday":
                    System.out.printf("Please, input new tasks for %s.\n", schedule[6][0]);
                    newTask = input.nextLine();
                    schedule[6][1] = newTask;
                    System.out.print("Please, input the day of the week: ");
                    break;
                //imperative commands end

                //Checking non-valid input
                default:
                    System.out.println("Sorry, I don't understand you, please try again.");
            }

            userInput = input.nextLine().toLowerCase().trim();

        }
    }
}

