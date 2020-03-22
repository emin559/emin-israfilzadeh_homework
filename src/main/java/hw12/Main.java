package hw12;

import hw12.controller.FamilyController;
import hw12.entities.*;
import hw12.exception.FamilyOverflowException;

import java.util.*;

public class Main {
  public static void main(String[] args) {

    FamilyController fc = new FamilyController();

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
        case "1":
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

          fc.familyService.dao.saveFamily(alderson);
          fc.familyService.dao.saveFamily(stark);

          Woman demoMom = new Woman("Demo1", "Demo1", "7/3/1985");
          Man demoDad = new Man("Demo2", "Demo2", "5/5/1983");
          Man demoChild = new Man("Demo3", "Demo3", "03/08/1983");
          fc.createNewFamily(demoDad, demoMom);
          fc.adoptChild(alderson, demoChild);
          demoChild.setSchedule(schedule);
          System.out.println("Test data created. Press enter to go back to main menu");
          command = input.nextLine();
          break;

        case "2":
          System.out.println(fc.displayAllFamilies());
          System.out.println("Press enter to go back to main menu");
          command = input.nextLine();
          break;

        case "3":
          System.out.println("Please add count:");
          var bigCount = Integer.parseInt(input.nextLine());
          System.out.println(fc.getFamiliesBiggerThan(bigCount));
          System.out.println("Press enter to go back to main menu");
          command = input.nextLine();
          break;

        case "4":
          System.out.println("Please add count:");
          var lessCount = Integer.parseInt(input.nextLine());
          System.out.println(fc.getFamiliesLessThan(lessCount));
          System.out.println("Press enter to go back to main menu");
          command = input.nextLine();
          break;

        case "5":
          System.out.println("Please add count:");
          var exactCount = Integer.parseInt(input.nextLine());
          System.out.println(fc.countFamiliesWithMemberNumber(exactCount));
          System.out.println("Press enter to go back to main menu");
          command = input.nextLine();
          break;

        case "6":
          System.out.print("Please enter mother's name:");
          String motherName = input.nextLine();
          System.out.print("Please enter mother's surname:");
          String motherSurname = input.nextLine();
          System.out.print("Please enter mothers' birthyear:");
          String motherBirthYear = input.nextLine();
          System.out.print("Please enter mothers' birthmonth:");
          String motherBirthMonth = input.nextLine();
          System.out.print("Please enter mothers' birthday:");
          String motherBirthDay = input.nextLine();
          System.out.print("Please enter mothers' iq:");
          int motherIq = Integer.parseInt(input.nextLine());

          StringBuilder motherBirthDate = new StringBuilder();
          motherBirthDate.append(motherBirthDay).append("/").append(motherBirthMonth).append("/").append(motherBirthYear);

          System.out.print("Please enter father's name:");
          String fatherName = input.nextLine();
          System.out.print("Please enter father's surname:");
          String fatherSurname = input.nextLine();
          System.out.print("Please enter father's birthyear:");
          String fatherBirthYear = input.nextLine();
          System.out.print("Please enter father's birthmonth:");
          String fatherBirthMonth = input.nextLine();
          System.out.print("Please enter father's birthday:");
          String fatherBirthDay = input.nextLine();
          System.out.print("Please enter father's iq:");
          int fatherIq = Integer.parseInt(input.nextLine());

          StringBuilder fatherBirthDate = new StringBuilder();
          fatherBirthDate.append(fatherBirthDay).append("/").append(fatherBirthMonth).append("/").append(fatherBirthYear);


          Human father = new Man(fatherName, fatherSurname, fatherBirthDate.toString());
          Human mother = new Woman(motherName, motherSurname, motherBirthDate.toString());
          father.setIq(fatherIq);
          mother.setIq(motherIq);

          Set<String> habits = new HashSet<>();
          habits.add("eat");
          habits.add("drink");
          habits.add("sleep");

          HashMap<String, String> schedule1 = new HashMap<>();
          schedule1.put(DayOfWeek.Monday.name(), "do home work");
          schedule1.put(DayOfWeek.Tuesday.name(), "go to courses");
          schedule1.put(DayOfWeek.Wednesday.name(), "watch a film");
          schedule1.put(DayOfWeek.Thursday.name(), "go for a walk");
          schedule1.put(DayOfWeek.Friday.name(), "meet with friends");
          schedule1.put(DayOfWeek.Saturday.name(), "play football");
          schedule1.put(DayOfWeek.Sunday.name(), "do not go out");
          ArrayList<Human> children = new ArrayList<>();
          Set<Pet> pets = new HashSet<>();
          Dog dog = new Dog("Nymeria", 1, 55, habits);
          Woman child = new Woman("Arya", "Stark", "10/11/1991");
          child.setSchedule(schedule1);
          Family family = new Family(mother, father, children);
          family.addChild(child);
          family.setPets(pets);
          pets.add(dog);
          fc.getAllFamilies().add(family);

          System.out.println("Family created successfully. Please press enter to go back to main menu!");
          command = input.nextLine();
          break;

        case "7":
          System.out.println("Please enter ID of family you want to delete");
          try {
            int familyId = Integer.parseInt(input.nextLine());
            fc.getAllFamilies().remove(familyId - 1);
            System.out.println("Family deleted sucessfully! Please press enter to go back to main menu");

          } catch (Exception e) {
            System.out.println("You entered wrong input.  Please press enter to go back to main menu");
          }
          break;

        case "8":
          System.out.println("Please choose operation: \n Enter 1 to give a birth, 2 to adopt a child");
          String operation = input.nextLine();
          try {
            if (operation.equals("1")) {
              System.out.println("Please enter family ID");
              int familyIdtoBirth = Integer.parseInt(input.nextLine());
              if (fc.getFamilyById(familyIdtoBirth).countFamily() < 5) {
                System.out.println("Please enter a name which u prefer for baby boy");
                String boyName = input.nextLine();
                System.out.println("Please enter a name which u prefer for baby girl");
                String girlName = input.nextLine();
                fc.bornChild(fc.getFamilyById(familyIdtoBirth), boyName, girlName);
                fc.saveFamily(fc.getFamilyById(familyIdtoBirth));
              } else {
                throw new FamilyOverflowException("Family can not include members more than 5!");
              }

            } else if (operation.equals("2")) {
              System.out.println("Please enter family ID");
              int familyIdtoAdopt = Integer.parseInt(input.nextLine());
              if (fc.getFamilyById(familyIdtoAdopt).countFamily() < 5) {

                System.out.println("Please enter a name of child:");
                String childName = input.nextLine();
                System.out.println("Please enter a surname of child:");
                String childSurname = input.nextLine();
                System.out.println("Please enter a birthdate year of child in following format DAY/MONTH/YEAR ");
                String childBirthYear = input.nextLine();
                System.out.println("Please enter Iq of child");
                int childIq = Integer.parseInt(input.nextLine());
                Human childAdopted = new Human(childName, childSurname, childBirthYear, childIq);
                fc.adoptChild(fc.getFamilyById(familyIdtoAdopt - 1), childAdopted);
              } else {
                throw new FamilyOverflowException("Family can not include members more than 5!");
              }

            }

          } catch (FamilyOverflowException e) {
            System.out.println(e.getMessage());
          } catch (Exception ex) {
            System.out.println("You entered wrong input.  Please press enter to go back to main menu");
          }

          break;

        case "9":
          System.out.println("Please enter age");
          int age = Integer.parseInt(input.nextLine());
          fc.deleteAllChildrenOlderThen(age);
          break;

      }

    }

  }

}