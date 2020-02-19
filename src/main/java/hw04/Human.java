package hw04;

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
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, int dateOfBirth, int iq, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    String name;
    String surname;
    int dateOfBirth;
    int iq;
    Pet pet;
    Human mother;
    Human father;
    String[][] schedule;

    void greetPet(Pet pet) {
        System.out.printf("Hello, %s\n", pet.nickname);
    }

    void describePet(Pet pet) {
        String petTrick = pet.trickLevel >= 50 ? "very sly!" : "almost not sly!";
        System.out.printf("I have a %s, he is %d years old, he is %s\n", pet.species, pet.age, petTrick);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", iq=" + iq +
                ", mother=" + mother.name +
                ", father=" + father.name +
                ", pet=" + pet +
                '}';
    }
}
