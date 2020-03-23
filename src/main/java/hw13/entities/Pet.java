package hw13.entities;

import java.util.Set;

public abstract class Pet {

  private Species species;
  private String nickname;
  private int age;
  private int trickLevel;
  private Set<String> habits;


  public Pet() {

  }

  public Pet(String nickname) {
    this.species = Species.UNKNOWN;
    this.nickname = nickname;
  }


  public Pet(String nickname, int age, int trickLevel, Set<String> habits) {
    this.species = Species.UNKNOWN;
    this.nickname = nickname;
    this.age = age;
    this.trickLevel = trickLevel;
    this.habits = habits;
  }

  public Species getSpecies() {
    return species;
  }

  public void setSpecies(Species species) {
    this.species = species;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getTrickLevel() {
    return trickLevel;
  }

  public void setTrickLevel(int trickLevel) {
    this.trickLevel = trickLevel;
  }

  public Set<String> getHabits() {
    return habits;
  }

  public void setHabits(Set<String> habits) {
    this.habits = habits;
  }

  String eat() {
    return "I am eating.\n";
  }

  abstract String foul();

  abstract String respond();

  public String representPet() {
    return String.format("Species: %s Nickname: %s age: %d tricklevel: %d habits: *%s", species, nickname, age, trickLevel, habits);
  }

  @Override
  public String toString() {
    return String.format("%s>%s>%d>%d>%s", species, nickname, age, trickLevel, habits);
  }

}
