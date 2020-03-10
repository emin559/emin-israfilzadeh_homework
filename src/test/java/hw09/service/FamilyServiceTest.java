package hw09.service;

import hw09.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FamilyServiceTest {

  private FamilyService testFamilyService;

  @BeforeEach
  void setUp() {
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


    Woman mAlderson = new Woman("Magda", "Alderson", 1985);
    Man fAlderson = new Man("Edward", "Alderson", 1983);
    fAlderson.setSchedule(schedule);
    ArrayList<Human> chAlderson = new ArrayList<>();
    Set<Pet> pAlderson = new HashSet<>();
    Dog qwerty = new Dog("qwerty", 1, 55, qwertyHabits);
    Man child1 = new Man("Eliot", "Alderson", 1991);
    child1.setSchedule(schedule);
    hw09.entities.Family alderson = new hw09.entities.Family(mAlderson, fAlderson, chAlderson);
    alderson.addChild(child1);
    alderson.setPets(pAlderson);
    pAlderson.add(qwerty);

    Woman mStark = new Woman("Catelyn", "Stark", 1985);
    Man fStark = new Man("Eddard", "Stark", 1983);
    ArrayList<Human> chStark = new ArrayList<>();
    Set<Pet> pStark = new HashSet<>();
    Dog nymeria = new Dog("Nymeria", 1, 55, qwertyHabits);
    Woman child2 = new Woman("Arya", "Stark", 1991);
    child2.setSchedule(schedule);
    hw09.entities.Family stark = new Family(mStark, fStark, chStark);
    stark.addChild(child2);
    stark.setPets(pStark);
    pStark.add(nymeria);


    testFamilyService = new FamilyService();
    testFamilyService.dao.saveFamily(alderson);
    testFamilyService.dao.saveFamily(stark);


  }

  @Test
  void getAllFamilies() {
    var expected = 2;
    var actual = testFamilyService.getAllFamilies().size();
    assertEquals(expected, actual);
  }

  @Test
  void getFamilyById() {
    var index = 1;
    Family expected = testFamilyService.familyList.get(index);
    Family actual = testFamilyService.getFamilyById(index);
    assertEquals(expected, actual);

  }

  @Test
  void displayAllFamilies() {

  }

  @Test
  void getFamiliesBiggerThan() {
    var index = 3;
    var expected = 0;
    var actual = testFamilyService.getFamiliesBiggerThan(index).size();
    assertEquals(expected, actual);

  }

  @Test
  void getFamiliesLessThan() {
    var index = 5;
    var expected = 2;
    var actual = testFamilyService.getFamiliesLessThan(index).size();
    assertEquals(expected, actual);

  }

  @Test
  void countFamiliesWithMemberNumber() {
    var index = 2;
    var expected = 0;
    var actual = testFamilyService.countFamiliesWithMemberNumber(index).size();
    assertEquals(expected, actual);

  }

  @Test
  void createNewFamily() {
    Woman demoMom = new Woman("Demo1", "Demo1", 1985);
    Man demoDad = new Man("Demo2", "Demo2", 1983);
    testFamilyService.createNewFamily(demoDad, demoMom);

    var expected = 3;
    var actual = testFamilyService.familyList.size();
    assertEquals(expected, actual);
  }

  @Test
  void bornChild() {
    Woman demoMom = new Woman("Demo1", "Demo1", 1985);
    Man demoDad = new Man("Demo2", "Demo2", 1983);
    testFamilyService.createNewFamily(demoDad, demoMom);

    var family = testFamilyService.familyList.get(2);
    testFamilyService.bornChild(family, "Jane", "Alex");

    var expected = 3;
    var actual = family.countFamily();
    assertEquals(expected, actual);
  }

  @Test
  void adoptChild() {
    Woman demoMom = new Woman("Demo1", "Demo1", 1985);
    Man demoDad = new Man("Demo2", "Demo2", 1983);
    testFamilyService.createNewFamily(demoDad, demoMom);
    Woman other = new Woman("Jane", "March", 2000);

    var family = testFamilyService.familyList.get(2);
    testFamilyService.adoptChild(family, other);

    var expected = 3;
    var actual = family.countFamily();
    assertEquals(expected, actual);

  }

  @Test
  void deleteAllChildrenOlderThen() {
    Woman demoMom = new Woman("Demo1", "Demo1", 1985);
    Man demoDad = new Man("Demo2", "Demo2", 1983);
    testFamilyService.createNewFamily(demoDad, demoMom);
    Woman other = new Woman("Jane", "March", 2000);
    Man other2 = new Man("Pablo", "Escobar", 1995);

    var family = testFamilyService.familyList.get(2);
    family.addChild(other);
    family.addChild(other2);

    testFamilyService.deleteAllChildrenOlderThen(23);

    var expected = 3;
    var actual = family.countFamily();

    assertEquals(expected, actual);

  }

  @Test
  void count() {
    var expected = 2;
    var actual = testFamilyService.getAllFamilies().size();
    assertEquals(expected, actual);

  }

  @Test
  void getPets() {
    Set<String> habits = new HashSet<>();
    habits.add("eat");
    habits.add("drink");
    habits.add("sleep");

    Woman demoMom = new Woman("Demo1", "Demo1", 1985);
    Man demoDad = new Man("Demo2", "Demo2", 1983);
    Pet pet1 = new Dog("Nick", 3, 55, habits);
    Pet pet2 = new Dog("Nick1", 3, 50, habits);
    testFamilyService.createNewFamily(demoDad, demoMom);
    var family = testFamilyService.familyList.get(2);

    testFamilyService.addPet(2, pet1);
    testFamilyService.addPet(2, pet2);

    var expected = 2;
    var actual = testFamilyService.getPets(2).size();
    assertEquals(expected, actual);

  }

  @Test
  void addPet() {
    Set<String> habits = new HashSet<>();
    habits.add("eat");
    habits.add("drink");
    habits.add("sleep");

    Woman demoMom = new Woman("Demo1", "Demo1", 1985);
    Man demoDad = new Man("Demo2", "Demo2", 1983);
    Pet pet1 = new Dog("Nick", 3, 55, habits);
    testFamilyService.createNewFamily(demoDad, demoMom);
    var family = testFamilyService.familyList.get(2);

    testFamilyService.addPet(2, pet1);

    var expected = 1;
    var actual = testFamilyService.getPets(2).size();
    assertEquals(expected, actual);
  }
}