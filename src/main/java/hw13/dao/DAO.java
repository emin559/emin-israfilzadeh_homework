package hw13.dao;

import java.util.List;

public interface DAO<T> {

  List<T> getAllFamilies();

  T getFamilyByIndex(int index);

  boolean deleteFamily(int index);

  boolean deleteFamily(T entity);

  void saveFamily(T entity);

}
