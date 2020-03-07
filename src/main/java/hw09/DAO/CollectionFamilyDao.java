package hw09.DAO;

import hw09.Entities.Family;
import hw09.Entities.Human;
import hw09.Entities.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionFamilyDao implements FamilyDao {
  List<Family> familyList;

  @Override
  public List<Family> getAllFamilies() {
    return this.familyList;
  }

  @Override
  public Family getFamilyByIndex(int index) {
    if (index < familyList.size()) return familyList.get(index);
    else {
      return null;
    }
  }

  @Override
  public boolean deleteFamilyByIndex(int index) {
    if (index < familyList.size()) {
      familyList.remove(index);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean deleteFamily(Family family) {
    if (familyList.contains(family)) {
      familyList.remove(family);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void saveFamily(Family family) {
    if (familyList.contains(family)) {
      var currentFamily = familyList.get(familyList.indexOf(family));
      currentFamily = family;
    } else {
      familyList.add(family);
    }
  }

  @Override
  public void displayAllFamilies() {
    familyList.forEach(fl -> System.out.println(fl.toString()));
  }

  @Override
  public List<Family> getFamiliesBiggerThan(int count) {
    List<Family> biggerFamily = Arrays.asList();
    for (Family family : familyList) {
      if (family.getCount() > count) biggerFamily.add(family);
    }
    System.out.printf("Families bigger than %d:\n %s", count, biggerFamily.toString());
    return biggerFamily;
  }

  @Override
  public List<Family> getFamiliesLessThan(int count) {
    List<Family> lessFamily = Arrays.asList();
    for (Family family : familyList) {
      if (family.getCount() < count) lessFamily.add(family);
    }
    System.out.printf("Families less than %d:\n %s", count, lessFamily.toString());
    return lessFamily;
  }

  @Override
  public List<Family> countFamiliesWithMemberNumber(int count) {
    List<Family> exactFamily = Arrays.asList();
    for (Family family : familyList) {
      if (family.getCount() == count) exactFamily.add(family);
    }
    System.out.printf("Families less than %d:\n %s", count, exactFamily.toString());
    return exactFamily;
  }

  @Override
  public void createNewFamily(Human man, Human woman) {
    ArrayList<Human> children = new ArrayList<>();
    Family family = new Family(woman, woman, children);
    familyList.add(family);
  }

  @Override
  public Family bornChild(Family family) {

    //should be filled
    return family;
  }

  @Override
  public Family adoptChild(Family family, Human child) {
    var currentFamily = familyList.get(familyList.indexOf(family));
    currentFamily.addChild(child);
    saveFamily(family);
    return family;
  }

  @Override
  public void deleteAllChildrenOlderThen(int age) {
    for (Family family : familyList) {
      List<Human> children = family.getChildren();
      for (Human child : children) {
        var date = 2020;
        if (age<(date-child.getYear())) children.remove(child);
      }
      saveFamily(family);
    }
  }

  @Override
  public int count() {
    return familyList.size();
  }

  @Override
  public List<Pet> getPets(int index) {
    var family = familyList.get(index);
    return family.getPets().stream().collect(Collectors.toList());
  }

  @Override
  public void addPet(int familyIndex, Pet pet) {
    var family = familyList.get(familyIndex);
    family.getPets().add(pet);
    saveFamily(family);
  }


}
