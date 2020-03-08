package hw10.Entities;

import java.util.Set;

public class RoboCat extends Pet {

  public RoboCat (String nickname, int age, int trickLevel, Set<String> habits) {
    this.setSpecies(Species.Robocat);
    this.setNickname(nickname);
    this.setAge(age);
    this.setTrickLevel(trickLevel);
    this.setHabits(habits);
  }


  @Override
  String respond() {
    return "Hi, i am your lovely dog!";
  }

  @Override
  public String foul() {
    return "I need to cover it up.\n";
  }
}
