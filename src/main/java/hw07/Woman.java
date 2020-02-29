package hw07;

public final class Woman extends Human {

  public Woman(String name, String surname, int year) {
    this.setName(name);
    this.setSurname(surname);
    this.setYear(year);
  }


  String Makeup() {
    return "I finished my makeup. I am ready to go. \n";
  }

  @Override
  String greetPet() {
    return String.format("Hello, %s. I am your Mummy \n", getFamily().getPet().getNickname());
  }
}
