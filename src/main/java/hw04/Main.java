package hw04;

public class Main {
  public static void main(String[] args) {

    String[] qwertyHabits = new String[] {"eat", "drink", "sleep"};

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

    Human mother = new Human("Magda", "Alderson", 1985);
    Human father = new Human("Edward", "Alderson", 1983);
    Pet pet = new Pet("dog", "qwerty", 1, 55, qwertyHabits);
    Human child = new Human("Eliot", "Alderson", 1991, 79, pet, mother, father, schedule);

    System.out.println(child.toString());
    System.out.print(child.greetPet());
    System.out.println(child.describePet());
    System.out.println(pet.toString());
    System.out.print(pet.eat());
    System.out.print(pet.respond());
    System.out.print(pet.foul());

    child.feedPet(false);
  }

}
