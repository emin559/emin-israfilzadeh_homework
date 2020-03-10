package hw12.DAO;

import hw12.Entities.*;

import java.util.*;

public class Main {
  public static void main(String[] args) {

    Set<String> qwertyHabits = new HashSet<>();
    qwertyHabits.add("eat");
    qwertyHabits.add("drink");
    qwertyHabits.add("sleep");

    HashMap<String, String> schedule = new HashMap<>();
    schedule.put(DayOfWeek.Monday.name(),
            "do home work");
    schedule.put(DayOfWeek.Tuesday.name(),
            "go to courses");
    schedule.put(DayOfWeek.Wednesday.name(),
            "watch a film");
    schedule.put(DayOfWeek.Thursday.name(),
            "go for a walk");
    schedule.put(DayOfWeek.Friday.name(),
            "meet with friends");
    schedule.put(DayOfWeek.Saturday.name(),
            "play football");
    schedule.put(DayOfWeek.Sunday.name(),
            "do not go out");

    Woman mAlderson = new Woman("Magda", "Alderson", "15/10/1985");
    Man fAlderson = new Man("Edward", "Alderson", "13/5/1983");
    ArrayList<Human> chAlderson = new ArrayList<>();
    Set<Pet> pAlderson = new HashSet<>();
    Dog qwerty = new Dog("qwerty", 1, 55, qwertyHabits);
    Man child1 = new Man("Eliot", "Alderson", "5/5/1991");
    child1.setSchedule(schedule);
    Family alderson = new Family(mAlderson, fAlderson, chAlderson);
    alderson.addChild(child1);
    alderson.setPets(pAlderson);
    pAlderson.add(qwerty);

    Woman mStark = new Woman("Catelyn", "Stark", "3/3/1985");
    Man fStark = new Man("Eddard", "Stark", "1/1/1983");
    ArrayList<Human> chStark = new ArrayList<>();
    Set<Pet> pStark = new HashSet<>();
    Dog nymeria = new Dog("Nymeria", 1, 55, qwertyHabits);
    Woman child2 = new Woman("Arya", "Stark", "10/11/1991");
    child2.setSchedule(schedule);
    Family stark = new Family(mStark, fStark, chStark);
    stark.addChild(child2);
    stark.setPets(pStark);
    pStark.add(nymeria);

    FamilyController fc = new FamilyController();
    fc.familyService.dao.saveFamily(alderson);
    fc.familyService.dao.saveFamily(stark);

    Woman demoMom = new Woman("Demo1", "Demo1", "7/3/1985");
    Man demoDad = new Man("Demo2", "Demo2", "5/5/1983");
    Man demoChild = new Man("Demo3", "Demo3", "03/08/1983");
    fc.createNewFamily(demoDad, demoMom);
    fc.adoptChild(alderson, demoChild);
    demoChild.setSchedule(schedule);

    StringBuilder commandList = new StringBuilder();
    commandList
            .append("============================================================================================================\n")
            .append("1. Fill with test data (create several families and save them in the database).\n")
            .append("2. Display the entire list of families (displays a list of all families with indexation starting with 1).\n")
            .append("3. Display a list of families where the number of people is greater than the specified number.\n")
            .append("4. Display a list of families where the number of people is less than the specified number.\n")
            .append("5. Calculate the number of families with the number of members.\n")
            .append("6. Create a new family.\n")
            .append("7. Delete a family by its index in the general list.\n")
            .append("8. Edit a family by its index in the general list.\n")
            .append("9. Remove all children over the age of majority.\n")
            .append("============================================================================================================\n")
            .append("Please choose your command:");


    String command = "";
    Scanner input = new Scanner(System.in);

    while (!(command.equals("exit"))) {

      System.out.println(commandList.toString());
      command = input.nextLine();

      switch (command) {
        case "2":
          fc.getAllFamilies();
          command = input.nextLine();

      }

    }

  }

}
