package hw07;

public class Dog extends Pet implements Foulable {

  public Dog (String nickname, int age, int trickLevel, String[] habits) {
    this.setSpecies(requiredEnums.Species.Dog);
    this.setNickname(nickname);
    this.setAge(age);
    this.setTrickLevel(trickLevel);
    this.setHabits(habits);
  }


  @Override
  String respond() {
    return null;
  }

  @Override
  public String foul() {
    return "I need to cover it up.\n";
  }
}
