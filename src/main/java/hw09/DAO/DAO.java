package hw09.DAO;

import java.util.List;

public interface DAO<T> {

  List<T> getAllFamilies();

  T getFamilyByIndex(int index);

  boolean deleteFamily(int index);

  boolean deleteFamily(T entity);

  void saveFamily(T entity);

}
