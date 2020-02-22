package hw05;

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
        robot.setName("Elliot");
        robot.setSurname("Alderson");
        robot.setDateOfBirth(1997);
        robot.setIq(97);
        robot.setPet(qwerty);
        robot.setMother(ma);
        robot.setFather(ea);
        robot.setSchedule(schedule);

        System.out.println(robot.toString());
        robot.describePet(qwerty);
        robot.greetPet(qwerty);

        qwerty.respond();
        System.out.println(qwerty.toString());
        qwerty.eat();
        qwerty.foul();


    }

}
