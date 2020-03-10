package hw12.Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Family {

  private Human mother;
  private Human father;
  private ArrayList<Human> children;
  private int childIndex = 0;
  private Set<Pet> pets;

  public Family(Human mother, Human father, ArrayList<Human> children) {
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

  public void setChildren(ArrayList<Human> children) {
    this.children = children;
  }

  public int getChildIndex() {
    return childIndex;
  }

  public void setChildIndex(int childIndex) {
    this.childIndex = childIndex;
  }

  public Set<Pet> getPets() {
    return pets;
  }

  public void setPets(Set<Pet> pets) {
    this.pets = pets;
  }

  public int addChild(Human child) {
    children.add(child);
    return children.size();
  }

  public boolean deleteChild(int index) {
    if (!(index >= children.size())) {
      children.remove(index);
      return true;
    }
    return false;
  }

  public int countFamily() {
    if (children != null) {
      return children.size() + 2;
    } else {
      return 0;
    }
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

  public String formatChildren() {
    String child = "";
    StringBuilder chb = new StringBuilder();
    DateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");

    for (Human ch : children) {
      chb.append(ch.getName()).append(": {");
      chb.append("name='").append(ch.getName()).append("', ");
      chb.append("surname='").append(ch.getSurname()).append("', ");
      chb.append("birthDate='").append(formatter.format(ch.getBirthDate())).append("', ");
      chb.append("iq='").append(ch.getIq()).append("', ");
      chb.append("schedule='").append(ch.getSchedule()).append("} \n");
    }
    child = chb.toString();
    return child;
  }

  public String prettyFormat() {
    DateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
    return "Family:\n" +
            "mother: {name='" + mother.getName() + "', '" + "surname='" + mother.getSurname() + "', '" + "birthDate='" + formatter.format(mother.getBirthDate()) + "', '" + "iq=" + mother.getIq() + ", " + "schedule=" + mother.getSchedule() + ", \n" +
            "father: {name='" + father.getName() + "', '" + "surname='" + father.getSurname() + "', '" + "birthDate='" + formatter.format(father.getBirthDate()) + "', '" + "iq=" + father.getIq() + ", " + "schedule=" + father.getSchedule() + ", \n" +
            "children:\n" + formatChildren() +
            "pets: " + pets.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Family family = (Family) o;
    return mother.equals(family.mother) &&
            father.equals(family.father) &&
            children.equals(family.children);
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
