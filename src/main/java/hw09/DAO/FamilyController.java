package hw09.DAO;

import hw09.Entities.Family;
import hw09.Entities.Human;
import hw09.Entities.Pet;

import java.util.List;

public class FamilyController {
  public FamilyService familyService = new FamilyService();

  public List<Family> getAllFamilies() {
    return familyService.getAllFamilies();
  }

  public void displayAllFamilies() {
    familyService.displayAllFamilies();
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

  public Family getFamilyById(int index) {
    return familyService.getFamilyById(index);
  }

  public List<Pet> getPets(int index) {
    return familyService.getPets(index);
  }

  public void addPet(int familyIndex, Pet pet) {
    familyService.addPet(familyIndex, pet);
  }
}
