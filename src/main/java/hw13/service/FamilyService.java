package hw13.service;

import hw13.dao.CollectionFamilyDao;
import hw13.entities.Family;
import hw13.entities.Human;
import hw13.entities.Pet;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {

  public CollectionFamilyDao dao = new CollectionFamilyDao();
  public List<Family> familyList = dao.getAllFamilies();


  public List<Family> getAllFamilies() {
    return familyList;
  }

  public Family getFamilyById(int index) {
    return dao.getFamilyByIndex(index);
  }

  public String displayAllFamilies() {
    return dao.getAllFamilies().stream()
            .map(family -> String.format("%s\n",family.prettyFormat()))
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
    int rn = (int) (Math.random() * 2);
    String name = rn == 0 ? masculine : feminine;
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
    familyList.forEach(f -> {
      int year = LocalDate.now().getYear();
      f.getChildren().removeIf(c -> age < (year -
              Instant.ofEpochMilli(c.getBirthDate()).atZone(ZoneId.systemDefault()).toLocalDate().getYear()));
      saveFamily(f);
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

  public Family getFamilyByIndex(int index) {
    return dao.getFamilyByIndex(index);
  }

  public boolean deleteFamily(int index) {
    return dao.deleteFamily(index);
  }

  public boolean deleteFamily(Family entity) {
    return dao.deleteFamily(entity);
  }

  public void saveFamily(Family entity) {
    dao.saveFamily(entity);
  }

  public void loadData() {
    dao.loadData();
  }

  public void getData() {
    dao.getData();
  }
}
