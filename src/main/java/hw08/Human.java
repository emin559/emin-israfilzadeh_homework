package hw08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Human {

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

  abstract String greetPet(int petIndex);

  String describePet(int petIndex) {
    String trick = family.getPets().get(petIndex).getTrickLevel()>=50 ? "very sly.\n" : "almost not sly.\n";
    return String.format("I have a %s, he is %d years old, he is %s", family.getPets().get(petIndex).getSpecies(), family.getPets().get(petIndex).getAge(), trick);
  }

  /*
  String schedule(String[][] schedule){
    if(schedule != null) {
      String scheduleString = "";
      StringBuilder str = new StringBuilder();
      str.append("[");
      for (String[] strings : schedule) {
        for (int task = 0; task < 1; task++) {
          str.append(String.format("[%s: ", strings[0]));
        }
        for (int task = 0; task < 1; task++) {
          str.append(String.format("%s], ", strings[1]));
        }

      }
      str.append("]");
      scheduleString = str.toString();
      return scheduleString;
    }
    return null;
  }
*/
  boolean feedPet(boolean hungry, int petIndex) {
    String hunger;
    if(hungry) {
      hunger = String.format("Hm... I will feed %s's %s.", name, family.getPets().get(petIndex).getNickname());
      System.out.println(hunger);
      return true;
    }
    else {
      Random random = new Random();
      int hungerRandom = random.nextInt(100);
      if(family.getPets().get(petIndex).getTrickLevel()>hungerRandom){
        hunger = String.format("Hm... I will feed %s's %s.", name, family.getPets().get(petIndex).getNickname());
        System.out.println(hunger);
        return true;
      }
      else {
        hunger = String.format("I think %s's %s is not hungry.", name, family.getPets().get(petIndex).getNickname());
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
