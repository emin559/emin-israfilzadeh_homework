package hw13.entities;

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

  public Family(Human mother, Human father, ArrayList<Human> children, Set<Pet> pets) {
    this.mother = mother;
    this.father = father;
    this.children = children;
    this.pets = pets;
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
    if (children!=null) {
      return children.size() + 2;
    }
    else{
      return 0;
    }
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
    return String.format("Family:\nmother: {name='%s', 'surname='%s', 'birthDate='%s', 'iq=%d, schedule=%s, \nfather: {name='%s', 'surname='%s', 'birthDate='%s', 'iq=%d, schedule=%s, \nchildren:\n%spets: %s", mother.getName(), mother.getSurname(), formatter.format(mother.getBirthDate()), mother.getIq(), mother.getSchedule(), father.getName(), father.getSurname(), formatter.format(father.getBirthDate()), father.getIq(), father.getSchedule(), formatChildren(), pets.toString());
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
            father.equals(family.father);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(mother, father, childIndex);
    result = 31 * result + children.hashCode();
    return result;
  }

  public String formatPet() {
    String pet = "";
    StringBuilder pb = new StringBuilder();

    for (Pet pet1 : pets) {
      pb.append(pet1.getSpecies()).append(">")
              .append(pet1.getNickname()).append(">")
              .append(pet1.getAge()).append(">")
              .append(pet1.getTrickLevel()).append(">")
              .append(pet1.getHabits());

    }
    pet = pb.toString();
    return pet;

  }

  public String representFamily() {
    return String.format("%s;%s;%s;%s",mother.representHuman(),father.representHuman(),children,formatPet());
  }


}
