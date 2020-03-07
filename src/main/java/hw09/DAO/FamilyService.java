package hw09.DAO;

import hw09.Entities.Family;
import hw09.Entities.Human;
import hw09.Entities.Pet;

import java.util.List;

public class FamilyService implements FamilyDao {
  FamilyDao familyDao;


  @Override
  public List<Family> getAllFamilies() {
    return familyDao.getAllFamilies();
  }

  @Override
  public Family getFamilyByIndex(int index) {
    return familyDao.getFamilyByIndex(index);
  }

  @Override
  public boolean deleteFamilyByIndex(int index) {
    return familyDao.deleteFamilyByIndex(index);
  }

  @Override
  public boolean deleteFamily(Family family) {
    return familyDao.deleteFamily(family);
  }

  @Override
  public void saveFamily(Family family) {
    familyDao.saveFamily(family);
  }

  @Override
  public void displayAllFamilies() {
    familyDao.displayAllFamilies();
  }

  @Override
  public List<Family> getFamiliesBiggerThan(int count) {
    return familyDao.getFamiliesBiggerThan(count);
  }

  @Override
  public List<Family> getFamiliesLessThan(int count) {
    return familyDao.getFamiliesLessThan(count);
  }

  @Override
  public List<Family> countFamiliesWithMemberNumber(int count) {
    return familyDao.countFamiliesWithMemberNumber(count);
  }

  @Override
  public void createNewFamily(Human man, Human woman) {
    familyDao.createNewFamily(man, woman);
  }

  @Override
  public Family bornChild(Family family) {
    return familyDao.bornChild(family);
  }

  @Override
  public Family adoptChild(Family family, Human child) {
    return familyDao.adoptChild(family, child);
  }

  @Override
  public void deleteAllChildrenOlderThen(int age) {
    familyDao.deleteAllChildrenOlderThen(age);
  }

  @Override
  public int count() {
    return familyDao.count();
  }

  @Override
  public List<Pet> getPets(int index) {
    return familyDao.getPets(index);
  }

  @Override
  public void addPet(int familyIndex, Pet pet) {
    familyDao.addPet(familyIndex, pet);
  }
}
