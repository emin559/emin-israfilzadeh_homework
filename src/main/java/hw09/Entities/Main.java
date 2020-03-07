package hw09.Entities;

import hw09.DAO.FamilyController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) {

    Set<String> qwertyHabits = new HashSet<>() {
    };
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

    ArrayList<Human> children = new ArrayList<>();
    Set<Pet> pets = new HashSet<>() {
    };

    Woman mother = new Woman("Magda", "Alderson", 1985);
    Man father = new Man("Edward", "Alderson", 1983);
    Dog qwerty = new Dog("qwerty", 1, 55, qwertyHabits);
    Man child1 = new Man("Eliot1", "Alderson", 1991);
    child1.setSchedule(schedule);
    Family family = new Family(mother, father, children);

    family.addChild(child1);
    family.addChild(child1);
    family.deleteChild(0);
    family.setPets(pets);
    pets.add(qwerty);
    //System.out.println(family.countFamily());

   // System.out.println(family.toString());

    FamilyController fc = new FamilyController();
    fc.service.getAllFamilies().add(family);
    fc.service.displayAllFamilies();

  }

}
