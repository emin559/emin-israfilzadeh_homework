package hw11;

import hw11.controller.FamilyController;
import hw11.entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
    fAlderson.setSchedule(schedule);
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

    System.out.println("");

    System.out.println(fc.getAllFamilies());
    System.out.println("");

    System.out.println(fc.displayAllFamilies());
    System.out.println("");

    System.out.println(fc.getFamiliesBiggerThan(1));
    System.out.println("");

    System.out.println(fc.getFamiliesLessThan(3));
    System.out.println("");

    System.out.println(fc.countFamiliesWithMemberNumber(1));
    System.out.println("");

    Woman demoMom = new Woman("Demo1", "Demo1", "7/3/1985");
    Man demoDad = new Man("Demo2", "Demo2", "5/5/1983");
    Man demoChild = new Man("Demo3", "Demo3", "03/08/1983");
    demoChild.setSchedule(schedule);
    fc.createNewFamily(demoDad, demoMom);
    fc.adoptChild(alderson, demoChild);

    System.out.printf("Count of families: %d\n", fc.count());
    System.out.println("");

    fc.deleteAllChildrenOlderThen(15);
    System.out.println(fc.getFamilyById(0));

    fc.addPet(1, qwerty);
    fc.addPet(2, nymeria);
    System.out.println(fc.getPets(1));

    fc.displayAllFamilies();

    fc.bornChild(alderson, "Elly", "Joel");
    System.out.println(alderson);

    System.out.println(mAlderson.describeAge());
  }

}
