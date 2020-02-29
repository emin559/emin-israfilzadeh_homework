package hw07;

public final class Man extends Human {

  public Man(String name, String surname, int year) {
    this.setName(name);
    this.setSurname(surname);
    this.setYear(year);
  }


  String repairCar() {
    return "I am ready to repair your car. \n";
  }

  @Override
  String greetPet() {
    return String.format("Hello, %s. I am your Dad. \n", getFamily().getPet().getNickname());

  }
}
