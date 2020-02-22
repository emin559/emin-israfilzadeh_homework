package hw05;

import java.util.Arrays;

public class Human {

    public Human() {


    }

    public Human(String name, String surname, int dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Human(String name, String surname, int dateOfBirth, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Human(String name, String surname, int dateOfBirth, int iq, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.iq = iq;
        this.schedule = schedule;
    }

    private String name;
    private String surname;
    private int dateOfBirth;
    private int iq;
    private Family family;
    private String[][] schedule;

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    void greetPet(Pet pet) {
        System.out.printf("Hello, %s\n", pet.getNickname());
    }

    void describePet(Pet pet) {
        String petTrick = pet.getTrickLevel() >= 50 ? "very sly!" : "almost not sly!";
        System.out.printf("I have a %s, he is %d years old, he is %s\n", pet.getSpecies(), pet.getAge(), petTrick);
    }


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", iq=" + iq +
                ", family=" + family +
                ", schedule=" + Arrays.toString(schedule) +
                '}';
    }
}
