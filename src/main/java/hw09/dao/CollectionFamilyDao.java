package hw09.dao;

import hw09.entities.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements DAO<Family> {
  private List<Family> familyList = new ArrayList<>();

  @Override
  public List<Family> getAllFamilies() {
    return this.familyList;
  }

  @Override
  public Family getFamilyByIndex(int index) {
    if (index < familyList.size()) return familyList.get(index);
    else {
      System.out.println();
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
    int index = familyList.indexOf(family);
    if(index != -1){
      familyList.set(index,family);
    } else{
      familyList.add(family);
    }
  }


}
