package hw09.Entities;

import java.util.ArrayList;

public final class Woman extends Human {

  public Woman(String name, String surname, int year) {
    this.setName(name);
    this.setSurname(surname);
    this.setYear(year);
  }


  String makeup() {
    return "I finished my makeup. I am ready to go. \n";
  }

  @Override
  String greetPet(int petIndex) {
    return String.format("Hello, %s. I am your Mummy \n", new ArrayList<>(getFamily().getPets()).get(petIndex).getNickname());
  }


}
