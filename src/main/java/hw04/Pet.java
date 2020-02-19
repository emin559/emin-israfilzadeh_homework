package hw04;

import java.util.Arrays;

public class Pet {

    public Pet() {
    }

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    String species;
    String nickname;
    int age;
    int trickLevel;
    String[] habits;

    void eat() {
        System.out.printf("I am eating\n");
    }

    void respond() {
        System.out.printf("Hello, owner. I am - %s. I miss you!\n", nickname);
    }

    void foul() {
        System.out.printf("I need to cover it up");
    }

    @Override
    public String toString() {
        return species + "{" +
                "species='" + species + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }
}
