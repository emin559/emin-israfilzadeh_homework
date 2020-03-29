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
    return dao.getAllFamilies().stream()
            .map(family -> String.format("%s\n",family))
            .collect(Collectors.joining());
  }

  public List<Family> getFamiliesBiggerThan(int count) {
    return familyList.stream().filter(family -> family.countFamily() > count).collect(Collectors.toList());

  }

  public List<Family> getFamiliesLessThan(int count) {
    return familyList.stream().filter(family -> family.countFamily() < count).collect(Collectors.toList());

  }

  public List<Family> countFamiliesWithMemberNumber(int count) {
    return familyList.stream().filter(family -> family.countFamily() == count).collect(Collectors.toList());
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
    var date = 2020;

    List<Human> children = new ArrayList<>();
    familyList.forEach(family -> {
      children.addAll(family.getChildren()
              .stream().filter(ch -> age < date - ch.getBirthDate()).collect(Collectors.toList()));
      familyList.removeAll(children);
      dao.saveFamily(family);
    });

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
