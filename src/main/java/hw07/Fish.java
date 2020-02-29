package hw07;

public class Fish extends Pet {

  public Fish (String nickname, int age, int trickLevel, String[] habits) {
    this.setSpecies(requiredEnums.Species.Fish);
    this.setNickname(nickname);
    this.setAge(age);
    this.setTrickLevel(trickLevel);
    this.setHabits(habits);
  }


  @Override
  String respond() {
    return null;
  }
}
