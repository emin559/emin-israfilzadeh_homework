package hw13.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public final class Man extends Human {

  public Man(String name, String surname, String birthDate) {
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

  public Man(String name, String surname, String birthDate, int iq) {
    this.setName(name);
    this.setSurname(surname);
    this.setIq(iq);
    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    try {
      Date date = format.parse(birthDate);
      this.setBirthDate(date.getTime());
    } catch (Exception e) {
      System.out.println("Wrong date input!");
    }
  }


  String repairCar() {
    return "I am ready to repair your car. \n";
  }

  @Override
  String greetPet(int petIndex) {
    return String.format("Hello, %s. I am your Dad. \n", new ArrayList<>(getFamily().getPets()).get(petIndex).getNickname());

  }

}
