package hw12.DAO;

import hw12.Entities.Family;
import hw12.Entities.Human;
import hw12.Entities.Pet;

import java.util.List;

public class FamilyController {
  public FamilyService familyService = new FamilyService();

  public void getAllFamilies() {
    familyService.displayAllFamilies();
  }

  public void displayAllFamilies() {
    familyService.displayAllFamilies();
  }

  public void getFamiliesBiggerThan(int count) {
    familyService.getFamiliesBiggerThan(count);
  }

  public void getFamiliesLessThan(int count) {
    familyService.getFamiliesLessThan(count);
  }

  public void countFamiliesWithMemberNumber(int count) {
    familyService.countFamiliesWithMemberNumber(count);
  }

  public void createNewFamily(Human man, Human woman) {
    familyService.createNewFamily(man, woman);
  }

  public Family bornChild(Family family) {

    //should be filled
    return family;
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

  public String getFamilyById(int index) {
    return familyService.getFamilyById(index);
  }

  public List<Pet> getPets(int index) {
    return familyService.getPets(index);
  }

  public void addPet(int familyIndex, Pet pet) {
    familyService.addPet(familyIndex, pet);
  }
}
