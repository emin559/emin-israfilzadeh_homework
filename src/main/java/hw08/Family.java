package hw08;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Family {

  private Human mother;
  private Human father;
  private List<Human> children;
  private int childIndex = 0;
  private List<Pet> pets;

  public Family(Human mother, Human father, List<Human> children) {
    this.mother = mother;
    this.father = father;
    this.children = children;
  }


  public Human getMother() {
    return mother;
  }

  public void setMother(Human mother) {
    this.mother = mother;
  }

  public Human getFather() {
    return father;
  }

  public void setFather(Human father) {
    this.father = father;
  }

  public List<Human> getChildren() {
    return children;
  }

  public void setChildren(List<Human> children) {
    this.children = children;
  }

  public int getChildIndex() {
    return childIndex;
  }

  public void setChildIndex(int childIndex) {
    this.childIndex = childIndex;
  }

  public List<Pet> getPets() {
    return pets;
  }

  public void setPets(List<Pet> pets) {
    this.pets = pets;
  }


  int addChild(Human child) {
    children.add(child);
    return children.size();
  }

  boolean deleteChild(int index) {
    if (!(index >= children.size())) {
      children.remove(index);
      return true;
    }
    return false;
  }

  int countFamily() {
    return children.size() + 2;
  }

  @Override
  public String toString() {
    return "Family{" +
            "mother=" + mother.getName() + " " + mother.getSurname() +
            ", father=" + father.getName() + " " + father.getSurname() +
            ", children=" + children.toString() +
            ", pets=" + pets.toString() +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Family family = (Family) o;
    return mother.equals(family.mother) &&
            father.equals(family.father) &&
            children.equals(family.children) &&
            getPets().size() == family.getPets().size();
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(mother, father, childIndex);
    result = 31 * result + children.hashCode();
    return result;
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Garbage collector is going to delete this Family class");
  }

}
