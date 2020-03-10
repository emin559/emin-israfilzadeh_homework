package hw08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Human {

  private String name;
  private String surname;
  private Family family;
  private int year;
  private int iq;
  private HashMap<String, String> schedule;

  public Human() {

  }

  public Human(String name, String surname, int year) {
    this.name = name;
    this.surname = surname;
    this.year = year;
  }

  public Human(String name, String surname, int year, Family family) {
    this.name = name;
    this.surname = surname;
    this.year = year;
    this.family = family;
  }

  public Human(String name, String surname, int year, int iq, Family family, HashMap<String, String> schedule) {
    this.name = name;
    this.surname = surname;
    this.year = year;
    this.iq = iq;
    this.family = family;
    this.schedule = schedule;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getIq() {
    return iq;
  }

  public void setIq(int iq) {
    this.iq = iq;
  }

  public Family getFamily() {
    return family;
  }

  public void setFamily(Family family) {
    this.family = family;
  }

  public Map<String, String> getSchedule() {
    return schedule;
  }

  public void setSchedule(HashMap<String, String> schedule) {
    this.schedule = schedule;
  }

  String greetPet(int petIndex) {
    return "Hello";
  };

  String describePet(int petIndex) {
    String trick = new ArrayList<>(family.getPets()).get(petIndex).getTrickLevel()>=50 ? "very sly.\n" : "almost not sly.\n";
    return String.format("I have a %s, he is %d years old, he is %s", new ArrayList<>(family.getPets()).get(petIndex).getSpecies(), new ArrayList<>(family.getPets()).get(petIndex).getAge(), trick);
  }

  boolean feedPet(boolean hungry, int petIndex) {
    String hunger;
    if(hungry) {
      hunger = String.format("Hm... I will feed %s's %s.", name, new ArrayList<>(family.getPets()).get(petIndex).getNickname());
      System.out.println(hunger);
      return true;
    }
    else {
      Random random = new Random();
      int hungerRandom = random.nextInt(100);
      if(new ArrayList<>(family.getPets()).get(petIndex).getTrickLevel()>hungerRandom){
        hunger = String.format("Hm... I will feed %s's %s.", name, new ArrayList<>(family.getPets()).get(petIndex).getNickname());
        System.out.println(hunger);
        return true;
      }
      else {
        hunger = String.format("I think %s's %s is not hungry.", name, new ArrayList<>(family.getPets()).get(petIndex).getNickname());
        System.out.println(hunger);
        return false;
      }
    }
  }

  @Override
  public String toString() {
    return "Human{" +
            "name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", year=" + year +
            ", iq=" + iq +
            ", schedule=" + schedule.toString() +
            '}';
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Garbage collector is going to delete this Human class");
  }
}
