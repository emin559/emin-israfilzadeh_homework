package hw09.DAO;

import hw09.Entities.Family;
import hw09.Entities.Human;
import hw09.Entities.Pet;

import java.util.List;

public interface FamilyDao {

  List<Family> getAllFamilies();

  Family getFamilyByIndex(int index);

  boolean deleteFamilyByIndex(int index);

  boolean deleteFamily(Family family);

  void saveFamily(Family family);

  void displayAllFamilies();

  List<Family> getFamiliesBiggerThan(int count);

  List<Family> getFamiliesLessThan(int count);

  List<Family> countFamiliesWithMemberNumber(int count);

  void createNewFamily(Human man, Human woman);

  Family bornChild(Family family);

  Family adoptChild(Family family, Human child);

  void deleteAllChildrenOlderThen(int age);

  int count();

  List<Pet> getPets(int index);

  void addPet(int familyIndex, Pet pet);


}
