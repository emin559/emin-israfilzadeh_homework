package hw11.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class Human {

  private String name;
  private String surname;
  private Family family;
  private long birthDate;
  private int iq;
  private HashMap<String, String> schedule;

  public Human() {

  }

  public Human(String name, String surname, String birthDate) {
    this.name = name;
    this.surname = surname;

    DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
    try {
      Date date = format.parse(birthDate);
      this.birthDate = date.getTime();
    } catch (Exception e) {
      System.out.println("Wrong date input!");
    }

  }

  public Human(String name, String surname, String birthDate, Family family) {
    this.name = name;
    this.surname = surname;
    this.family = family;
    DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
    try {
      Date date = format.parse(birthDate);
      this.birthDate = date.getTime();
    } catch (Exception e) {
      System.out.println("Wrong date input!");
    }

  }

  public Human(String name, String surname, String birthDate, int iq) {
    this.name = name;
    this.surname = surname;
    this.iq = iq;
    DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
    try {
      Date date = format.parse(birthDate);
      this.birthDate = date.getTime();
    } catch (Exception e) {
      System.out.println("Wrong date input!");
    }
  }

  public Human(String name, String surname, String birthDate, int iq, Family family, HashMap<String, String> schedule) {
    this.name = name;
    this.surname = surname;
    this.iq = iq;
    this.family = family;
    this.schedule = schedule;
    DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
    try {
      Date date = format.parse(birthDate);
      this.birthDate = date.getTime();
    } catch (Exception e) {
      System.out.println("Wrong date input!");
    }

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

  public long getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(long birthDate) {
    this.birthDate = birthDate;
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

  public HashMap<String, String> getSchedule() {
    return schedule;
  }

  public void setSchedule(HashMap<String, String> schedule) {
    this.schedule = schedule;
  }

  String greetPet(int petIndex){
    return "Hello";
  }

  String describePet(int petIndex) {
    String trick = new ArrayList<>(family.getPets()).get(petIndex).getTrickLevel() >= 50 ? "very sly.\n" : "almost not sly.\n";
    return String.format("I have a %s, he is %d years old, he is %s", new ArrayList<>(family.getPets()).get(petIndex).getSpecies(), new ArrayList<>(family.getPets()).get(petIndex).getAge(), trick);
  }

  boolean feedPet(boolean hungry, int petIndex) {
    String hunger;
    if (hungry) {
      hunger = String.format("Hm... I will feed %s's %s.", name, new ArrayList<>(family.getPets()).get(petIndex).getNickname());
      System.out.println(hunger);
      return true;
    } else {
      Random random = new Random();
      int hungerRandom = random.nextInt(100);
      if (new ArrayList<>(family.getPets()).get(petIndex).getTrickLevel() > hungerRandom) {
        hunger = String.format("Hm... I will feed %s's %s.", name, new ArrayList<>(family.getPets()).get(petIndex).getNickname());
        System.out.println(hunger);
        return true;
      } else {
        hunger = String.format("I think %s's %s is not hungry.", name, new ArrayList<>(family.getPets()).get(petIndex).getNickname());
        System.out.println(hunger);
        return false;
      }
    }
  }

  public String describeAge() {
    DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
    LocalDate today = LocalDate.now();
    Date birthday = new Date(birthDate);
    LocalDate localBD = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    Period p = Period.between(localBD, today);
    String age = String.format("%s years %s months %s days", p.getYears(), p.getMonths(), p.getDays());


    return age;
  }

  @Override
  public String toString() {
    DateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
    String dateFormatted = formatter.format(birthDate);
    return "Human{" +
            "name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", Date of birth='" + dateFormatted +
            "', iq=" + iq +
            ", schedule=" + schedule.toString() +
            '}';
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Garbage collector is going to delete this Human class");
  }
}