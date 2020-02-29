package hw07;

public class DomesticCat extends Pet implements Foulable {

  public DomesticCat (String nickname, int age, int trickLevel, String[] habits) {
    this.setSpecies(requiredEnums.Species.DomesticCat);
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
