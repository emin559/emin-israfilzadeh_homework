package hw09.DAO;

import hw09.Entities.Family;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionFamilyDao implements DAO<Family> {
  List<Family> familyList = new ArrayList<>(Arrays.asList());

  @Override
  public List<Family> getAllFamilies() {
    return this.familyList;
  }

  @Override
  public Family getFamilyByIndex(int index) {
    if (index < familyList.size()) return familyList.get(index);
    else {
      return null;
    }
  }

  @Override
  public boolean deleteFamily(int index) {
    if (index < familyList.size()) {
      familyList.remove(index);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean deleteFamily(Family family) {
    if (familyList.contains(family)) {
      familyList.remove(family);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void saveFamily(Family family) {
    if (familyList.contains(family)) {
      var currentFamily = familyList.get(familyList.indexOf(family));
      currentFamily = family;
    } else {
      familyList.add(family);
    }
  }


}
