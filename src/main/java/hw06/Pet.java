package hw06;

import java.util.Arrays;

public class Pet {

  private requiredEnums.Species species;
  private String nickname;
  private int age;
  private int trickLevel;
  private String[] habits;


  public Pet() {

  }

  public Pet(requiredEnums.Species species, String nickname) {
    this.species = species;
    this.nickname = nickname;
  }

  public Pet(requiredEnums.Species species, String nickname, int age, int trickLevel, String[] habits) {
    this.species = species;
    this.nickname = nickname;
    this.age = age;
    this.trickLevel = trickLevel;
    this.habits = habits;
  }


  public requiredEnums.Species getSpecies() {
    return species;
  }

  public void setSpecies(requiredEnums.Species species) {
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

  public String[] getHabits() {
    return habits;
  }

  public void setHabits(String[] habits) {
    this.habits = habits;
  }

  String eat() {
    return "I am eating.\n";
  }

  String respond() {
    return String.format("Hello, owner. I am - %s. I miss you!\n", nickname);
  }

  String foul() {
    return "I need to cover it up.\n";
  }

  @Override
  public String toString() {
    return  getSpecies() + "{" + "nickname='" + nickname + '\'' +
            ", age='" + age + '\'' +
            ", trickLevel=" + trickLevel +
            ", habits='" + Arrays.toString(habits) + '\'' +
            '}';
  }

}
