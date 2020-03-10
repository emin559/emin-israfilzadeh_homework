package hw12.DAO;

import hw12.Entities.Family;
import hw12.Entities.Human;
import hw12.Entities.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {

  public DAO<Family> dao = new CollectionFamilyDao();
  public List<Family> familyList = dao.getAllFamilies();

  public List<Family> getAllFamilies() {
    return familyList;
  }

  public void displayAllFamilies() {
    familyList.forEach(fl -> System.out.println((familyList.indexOf(fl) + 1) + ". " + fl.prettyFormat()));
  }

  public void getFamiliesBiggerThan(int count) {
    List<Family> biggerFamily = new ArrayList<>(Arrays.asList());

    familyList.forEach(fm -> {
      if (fm.countFamily() > count) biggerFamily.add(fm);
    });

    biggerFamily.forEach(bf -> System.out.println((biggerFamily.indexOf(bf) + 1) + ". " + bf.prettyFormat()));
  }

  public void getFamiliesLessThan(int count) {
    List<Family> lessFamily = new ArrayList<>(Arrays.asList());

    familyList.forEach(fm -> {
      if (fm.countFamily() < count) lessFamily.add(fm);
    });

    lessFamily.forEach(lf -> System.out.println((lessFamily.indexOf(lf) + 1) + ". " + lf.prettyFormat()));
  }

  public void countFamiliesWithMemberNumber(int count) {
    List<Family> exactFamily = new ArrayList<>(Arrays.asList());

    familyList.forEach(fm -> {
      if (fm.countFamily() == count) exactFamily.add(fm);
    });

    exactFamily.forEach(ef -> System.out.println((exactFamily.indexOf(ef) + 1) + ". " + ef.prettyFormat()));
  }

  public void createNewFamily(Human man, Human woman) {
    ArrayList<Human> children = new ArrayList<>();
    Family family = new Family(woman, woman, children);
    familyList.add(family);
  }

  public Family bornChild(Family family) {

    //should be filled
    return family;
  }

  public Family adoptChild(Family family, Human child) {
    var currentFamily = familyList.get(familyList.indexOf(family));
    currentFamily.addChild(child);
    dao.saveFamily(family);
    return family;
  }

  public void deleteAllChildrenOlderThen(int age) {
    for (Family family : familyList) {
      List<Human> children = family.getChildren();
      var date = 2020;
      children.removeIf(ch -> age < (date - ch.getBirthDate()));
      dao.saveFamily(family);
    }
  }

  public int count() {
    return familyList.size();
  }

  public String getFamilyById(int index) {
    return dao.getFamilyByIndex(index);
  }

  public List<Pet> getPets(int index) {
    var family = familyList.get(index);
    return family.getPets().stream().collect(Collectors.toList());
  }

  public void addPet(int familyIndex, Pet pet) {
    var family = familyList.get(familyIndex);
    family.getPets().add(pet);
    dao.saveFamily(family);
  }

}
