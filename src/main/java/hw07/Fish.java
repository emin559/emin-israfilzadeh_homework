package hw07;

public class Fish extends Pet {

  public Fish (String nickname, int age, int trickLevel, String[] habits) {
    this.setSpecies(Species.Fish);
    this.setNickname(nickname);
    this.setAge(age);
    this.setTrickLevel(trickLevel);
    this.setHabits(habits);
  }

  @Override
  String foul() {
    return "I need to cover it up.\n";

  }


  @Override
  String respond() {
    return "Hi, i am your lovely fish!";
  }
}
