package hw09.DAO;

import hw09.Entities.Family;
import hw09.Entities.Human;
import hw09.Entities.Pet;

import java.util.List;

public class FamilyController extends FamilyService {
  public FamilyService service = new FamilyService();

  public List<Family> getAllFamilies() {
    return service.getAllFamilies();
  }

  public Family getFamilyByIndex(int index) {
    return service.getFamilyByIndex(index);
  }

  public boolean deleteFamilyByIndex(int index) {
    return service.deleteFamilyByIndex(index);
  }

  public boolean deleteFamily(Family family) {
    return service.deleteFamily(family);
  }

  public void saveFamily(Family family) {
    service.saveFamily(family);
  }

  public void displayAllFamilies() {
    service.displayAllFamilies();
  }

  public List<Family> getFamiliesBiggerThan(int count) {
    return service.getFamiliesBiggerThan(count);
  }

  public List<Family> getFamiliesLessThan(int count) {
    return service.getFamiliesLessThan(count);
  }

  public List<Family> countFamiliesWithMemberNumber(int count) {
    return service.countFamiliesWithMemberNumber(count);
  }

  public void createNewFamily(Human man, Human woman) {
    service.createNewFamily(man, woman);
  }

  public Family bornChild(Family family) {
    return service.bornChild(family);
  }

  public Family adoptChild(Family family, Human child) {
    return service.adoptChild(family, child);
  }

  public void deleteAllChildrenOlderThen(int age) {
    service.deleteAllChildrenOlderThen(age);
  }

  public int count() {
    return service.count();
  }

  public List<Pet> getPets(int index) {
    return service.getPets(index);
  }

  public void addPet(int familyIndex, Pet pet) {
    service.addPet(familyIndex, pet);
  }
}
