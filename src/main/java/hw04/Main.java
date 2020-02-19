package hw04;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
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

        String[] habits = new String[]{"eat", "drink", "sleep"};

        Human ea = new Human("Edward", "Alderson", 1981);
        Human ma = new Human("Magda", "Alderson", 1982);
        Pet qwerty = new Pet("dog", "qwerty", 1, 75, habits);

        Human robot = new Human();
        robot.name = "Elliot";
        robot.surname = "Alderson";
        robot.dateOfBirth = 1997;
        robot.iq = 97;
        robot.pet = qwerty;
        robot.mother = ma;
        robot.father = ea;
        robot.schedule = schedule;

        System.out.println(robot.toString());
        robot.describePet(qwerty);
        robot.greetPet(qwerty);

        qwerty.respond();
        System.out.println(qwerty.toString());
        qwerty.eat();
        qwerty.foul();


    }

}
