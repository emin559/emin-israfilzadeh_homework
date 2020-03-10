package hw11.service;

import hw11.dao.CollectionFamilyDao;
import hw11.dao.DAO;
import hw11.entities.Family;
import hw11.entities.Human;
import hw11.entities.Pet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {

  public DAO<Family> dao = new CollectionFamilyDao();
  public List<Family> familyList = dao.getAllFamilies();


  public List<Family> getAllFamilies() {
    return familyList;
  }

  public Family getFamilyById(int index) {
    return dao.getFamilyByIndex(index);
  }


  public String displayAllFamilies() {
    StringBuilder dAllFamilies = new StringBuilder();
    dao.getAllFamilies().forEach(fl -> dAllFamilies.append(fl).append("/n"));
    return dAllFamilies.toString();
  }

  public List<Family> getFamiliesBiggerThan(int count) {
    List<Family> biggerFamily = familyList.stream().filter(family -> family.countFamily() > count).collect(Collectors.toList());

    return biggerFamily;
  }

  public List<Family> getFamiliesLessThan(int count) {
    List<Family> lessFamily = familyList.stream().filter(family -> family.countFamily() < count).collect(Collectors.toList());

    return lessFamily;
  }

  public List<Family> countFamiliesWithMemberNumber(int count) {
    List<Family> exactFamily = familyList.stream().filter(family -> family.countFamily() == count).collect(Collectors.toList());

    return exactFamily;
  }

  public void createNewFamily(Human man, Human woman) {
    ArrayList<Human> children = new ArrayList<>();
    Set<Pet> pets = new HashSet<>();
    Family family = new Family(woman, man, children);
    family.setPets(pets);
    familyList.add(family);
  }

  public Family bornChild(Family family, String masculine, String feminine) {
    int rn = (int)(Math.random()*2);
    String name = rn==0? masculine: feminine;
    Human child = new Human(name, family.getFather().getSurname(), "15/5/1995");
    child.setSchedule(family.getFather().getSchedule());
    child.setIq(55);
    familyList.get(familyList.indexOf(family)).addChild(child);
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
