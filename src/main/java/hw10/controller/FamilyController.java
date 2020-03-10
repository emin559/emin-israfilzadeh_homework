package hw10.controller;

import hw10.entities.Family;
import hw10.entities.Human;
import hw10.entities.Pet;
import hw10.service.FamilyService;

import java.util.List;

public class FamilyController {
  public FamilyService familyService = new FamilyService();

  public List<Family> getAllFamilies() {
    return familyService.getAllFamilies();
  }

  public Family getFamilyById(int index) {
    return familyService.getFamilyById(index);
  }

  public String displayAllFamilies() {
    return familyService.displayAllFamilies();
  }

  public List<Family> getFamiliesBiggerThan(int count) {
    return familyService.getFamiliesBiggerThan(count);
  }

  public List<Family> getFamiliesLessThan(int count) {
    return familyService.getFamiliesLessThan(count);
  }

  public List<Family> countFamiliesWithMemberNumber(int count) {
    return familyService.countFamiliesWithMemberNumber(count);
  }

  public void createNewFamily(Human man, Human woman) {
    familyService.createNewFamily(man, woman);
  }

  public Family bornChild(Family family, String masculine, String feminine) {

    return familyService.bornChild(family, masculine, feminine);
  }

  public Family adoptChild(Family family, Human child) {
    return familyService.adoptChild(family, child);
  }

  public void deleteAllChildrenOlderThen(int age) {
    familyService.deleteAllChildrenOlderThen(age);
  }

  public int count() {
    return familyService.count();
  }

  public List<Pet> getPets(int index) {
    return familyService.getPets(index);
  }

  public void addPet(int familyIndex, Pet pet) {
    familyService.addPet(familyIndex, pet);
  }
}
