package hw06;

import java.util.Random;

public class Human {

  private String name;
  private String surname;
  private Family family;
  private int year;
  private int iq;
  private String[][] schedule;

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

  public Human(String name, String surname, int year, int iq, Family family, String[][] schedule) {
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

  public String[][] getSchedule() {
    return schedule;
  }

  public void setSchedule(String[][] schedule) {
    this.schedule = schedule;
  }


  String greetPet() {
    return String.format("Hello, %s.\n", family.getPet().getNickname());
  }

  String describePet() {
    String trick = family.getPet().getTrickLevel()>=50 ? "very sly.\n" : "almost not sly.\n";
    return String.format("I have a %s, he is %d years old, he is %s", family.getPet().getSpecies(), family.getPet().getAge(), trick);
  }

  String schedule(String[][] schedule){
    if(schedule != null) {
      String scheduleString;
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

  boolean feedPet(boolean hungry) {
    String hunger;
    if(hungry) {
      hunger = String.format("Hm... I will feed %s's %s.", name, family.getPet().getNickname());
      System.out.println(hunger);
      return true;
    }
    else {
      Random random = new Random();
      int hungerRandom = random.nextInt(100);
      if(family.getPet().getTrickLevel()>hungerRandom){
        hunger = String.format("Hm... I will feed %s's %s.", name, family.getPet().getNickname());
        System.out.println(hunger);
        return true;
      }
      else {
        hunger = String.format("I think %s's %s is not hungry.", name, family.getPet().getNickname());
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
            ", schedule=" + schedule(schedule) +
            '}';
  }

}
