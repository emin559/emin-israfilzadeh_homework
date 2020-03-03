package hw08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

  private Family testFamily;

  @BeforeEach
  void setUp() {
    List<Human> children = new ArrayList<>();
    Human mother = new Woman("Magda", "Alderson", 1985);
    Human father = new Man("Edward", "Alderson", 1983);
    this.testFamily = new Family(mother, father, children);
  }

  @Test
  void deleteChild1() {
    Human child1 = new Man("Eliot1", "Alderson", 1991);

    testFamily.addChild(child1);
    boolean expected = true;
    boolean actual = testFamily.deleteChild(0);
    assertEquals(expected, actual);

  }

  @Test
  void deleteChild2() {
    Human child1 = new Man("Eliot1", "Alderson", 1991);

    testFamily.addChild(child1);
    boolean expected = false;
    boolean actual = testFamily.deleteChild(5);
    assertEquals(expected, actual);

  }


  @Test
  void addChild() {
    Human child1 = new Man("Eliot1", "Alderson", 1991);

    int expected = 1;
    int actual = testFamily.addChild(child1);
    assertEquals(expected, actual);

  }

  @Test
  void Count() {
    Human child1 = new Man("Eliot1", "Alderson", 1991);
    testFamily.addChild(child1);
    testFamily.addChild(child1);
    testFamily.deleteChild(0);
    int expected = 3;
    int actual = testFamily.countFamily();
    assertEquals(expected, actual);

  }
}