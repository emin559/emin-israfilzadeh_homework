package hw13;

import hw13.controller.FamilyController;
import hw13.entities.*;
import hw13.exception.FamilyOverflowException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {

    FamilyController fc = new FamilyController();
    fc.getData();

    StringBuilder commandList = new StringBuilder();
    commandList
            .append("============================================================================================================\n")
            .append("1. Load data from database \n")
            .append("2. Display the entire list of families (displays a list of all families with indexation starting with 1).\n")
            .append("3. Display a list of families where the number of people is greater than the specified number.\n")
            .append("4. Display a list of families where the number of people is less than the specified number.\n")
            .append("5. Calculate the number of families with the number of members.\n")
            .append("6. Create a new family.\n")
            .append("7. Delete a family by its index in the general list.\n")
            .append("8. Edit a family by its index in the general list.\n")
            .append("9. Remove all children over the age of majority.\n")
            .append("10. Save data.\n")
            .append("============================================================================================================\n")
            .append("Please choose your command:");


    String command = "";
    Scanner input = new Scanner(System.in);

    while (!(command.equals("exit"))) {

      System.out.println(commandList.toString());
      command = input.nextLine();

      switch (command) {
        case "1":
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

          ArrayList<Human> children = new ArrayList<>();
          Set<Pet> pets = new HashSet<>();
          Dog dog = new Dog("Nymeria", 1, 55, habits);
          Family family = new Family(mother, father, children);
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
                fc.adoptChild(fc.getFamilyById(familyIdtoAdopt), childAdopted);
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

        case "10":
          fc.loadData();
          System.out.println("Data saved!");
          break;

      }

    }

  }

}