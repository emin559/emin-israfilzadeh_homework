package hw05;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;

public class Family {

    public Family(Human mother, Human father, Human[] children) {
        this.mother = mother;
        this.father = father;
        this.children = children;
    }

    private Human mother;
    private Human father;
    private Human[] children;
    private int childIndex = 0;
    private Pet pet;

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getChildIndex() {
        return childIndex;
    }

    public void setChildIndex(int childIndex) {
        this.childIndex = childIndex;
    }

    void addChild(Human child) {
        children[childIndex] = child;
        childIndex++;
    }

    boolean deleteChild(int deleteIndex) {
        for (int i = 0; i <= children.length; i++) {
            if (i==deleteIndex){
                children[i]= children[i+1];
                childIndex--;
                break;
            }
            else {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + Arrays.toString(children) +
                ", childIndex=" + childIndex +
                ", pet=" + pet +
                '}';
    }

    int countFamily(){
        return 2+childIndex;
    }

}
