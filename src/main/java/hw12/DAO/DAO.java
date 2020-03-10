package hw12.DAO;

import java.util.List;

public interface DAO<T> {

  List<T> getAllFamilies();

  String getFamilyByIndex(int index);

  boolean deleteFamily(int index);

  boolean deleteFamily(T entity);

  void saveFamily(T entity);

}
