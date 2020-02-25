package hw04;

import java.util.Arrays;

public class Pet {

  String species;
  String nickname;
  int age;
  int trickLevel;
  String[] habits;

  public Pet() {

  }

  public Pet(String species, String nickname) {
    this.species = species;
    this.nickname = nickname;
  }

  public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
    this.species = species;
    this.nickname = nickname;
    this.age = age;
    this.trickLevel = trickLevel;
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
    return  species + "{" + "nickname='" + nickname + '\'' +
            ", age='" + age + '\'' +
            ", trickLevel=" + trickLevel +
            ", habits='" + Arrays.toString(habits) + '\'' +
            '}';
  }
}
