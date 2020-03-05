package hw08;

import java.util.ArrayList;

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
  String greetPet(int petIndex) {
    return String.format("Hello, %s. I am your Dad. \n", new ArrayList<>(getFamily().getPets()).get(petIndex).getNickname());

  }


}
