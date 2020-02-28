package hw06;

public class Main {
  public static void main(String[] args) {

    String[] qwertyHabits = new String[] {"eat", "drink", "sleep"};

    String[][] schedule = new String[7][2];
    schedule[0][0] = requiredEnums.DayOfWeek.Monday.name();
    schedule[0][1] = "do home work";
    schedule[1][0] = requiredEnums.DayOfWeek.Tuesday.name();
    schedule[1][1] = "go to courses";
    schedule[2][0] = requiredEnums.DayOfWeek.Wednesday.name();
    schedule[2][1] = "watch a film";
    schedule[3][0] = requiredEnums.DayOfWeek.Thursday.name();
    schedule[3][1] = "go for a walk";
    schedule[4][0] = requiredEnums.DayOfWeek.Friday.name();
    schedule[4][1] = "meet with friends";
    schedule[5][0] = requiredEnums.DayOfWeek.Saturday.name();
    schedule[5][1] = "play football";
    schedule[6][0] = requiredEnums.DayOfWeek.Sunday.name();
    schedule[6][1] = "do not go out";

    Human[] children = new Human[10];

    Human mother = new Human("Magda", "Alderson", 1985);
    Human father = new Human("Edward", "Alderson", 1983);
    Pet qwerty = new Pet(requiredEnums.Species.Dog, "qwerty", 1, 55, qwertyHabits);
    Human child1 = new Human("Eliot1", "Alderson", 1991);
    child1.setSchedule(schedule);
    Family family = new Family(mother, father, children);

    family.addChild(child1);
    family.addChild(child1);
    family.deleteChild(0);
    family.setPet(qwerty);
    System.out.println(family.countFamily());


    System.out.println(family.toString());

    for (int i = 0; i < 10000000 ; i++) {
        new Human();
    }



  }

}
