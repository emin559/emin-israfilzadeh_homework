package hw12.Entities;

import java.util.Set;

public class DomesticCat extends Pet {

  public DomesticCat (String nickname, int age, int trickLevel, Set<String> habits) {
    this.setSpecies(Species.DomesticCat);
    this.setNickname(nickname);
    this.setAge(age);
    this.setTrickLevel(trickLevel);
    this.setHabits(habits);
  }

  @Override
  String respond() {
    return "Hi, i am your lovely cat!";
  }

  @Override
  public String foul() {
    return "I need to cover it up.\n";
  }
}
