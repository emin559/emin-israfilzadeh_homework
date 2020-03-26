package hw10.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public final class Woman extends Human {

  public Woman(String name, String surname, String birthDate) {
    this.setName(name);
    this.setSurname(surname);
    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    try{
      Date date = format.parse(birthDate);
      this.setBirthDate(date.getTime());
    }
    catch(Exception e) {
      System.out.println("Wrong date input!");
    }
  }


  String makeup() {
    return "I finished my makeup. I am ready to go. \n";
  }

  @Override
  String greetPet(int petIndex) {
    return String.format("Hello, %s. I am your Mummy \n", new ArrayList<>(getFamily().getPets()).get(petIndex).getNickname());
  }


}