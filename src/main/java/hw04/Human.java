package hw04;

import java.util.Arrays;
import java.util.Random;

public class Human {

  String name;
  String surname;
  int year;
  int iq;
  Pet pet;
  Human mother;
  Human father;
  String[][] schedule;

  public Human() {

  }

  public Human(String name, String surname, int year) {
    this.name = name;
    this.surname = surname;
    this.year = year;
  }

  public Human(String name, String surname, int year, Human mother, Human father) {
    this.name = name;
    this.surname = surname;
    this.year = year;
    this.mother = mother;
    this.father = father;
  }

  public Human(String name, String surname, int year, int iq, Pet pet, Human mother, Human father, String[][] schedule) {
    this.name = name;
    this.surname = surname;
    this.year = year;
    this.iq = iq;
    this.pet = pet;
    this.mother = mother;
    this.father = father;
    this.schedule = schedule;
  }


  String greetPet() {
    return String.format("Hello, %s.\n", pet.nickname);
  }

  String describePet() {
    String trick = pet.trickLevel>=50 ? "very sly.\n" : "almost not sly.\n";
    return String.format("I have a %s, he is %d years old, he is %s", pet.species, pet.age, trick);
  }

  @Override
  public String toString() {
    return "Human{" +
            "name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", year=" + year +
            ", iq=" + iq +
            ", mother=" + mother.name + " " + mother.surname +
            ", father=" + father.name + " " + father.surname +
            ", pet=" + pet.toString() +
            '}';
  }

  boolean feedPet(boolean hungry) {
    String hunger;
    if(hungry) {
        hunger = String.format("Hm... I will feed %s's %s.", name, pet.nickname);
      System.out.println(hunger);
      return true;
    }
    else {
      Random random = new Random();
      int hungerRandom = random.nextInt(100);
      if(pet.trickLevel>hungerRandom){
        hunger = String.format("Hm... I will feed %s's %s.", name, pet.nickname);
        System.out.println(hunger);
        return true;
      }
      else {
        hunger = String.format("I think %s's %s is not hungry.", name, pet.nickname);
        System.out.println(hunger);
        return false;
      }
    }
  }
}
