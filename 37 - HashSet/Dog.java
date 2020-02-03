package hw38;

import java.util.Objects;

public class Dog {
    private String name;
    private double weight;

    public Dog(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }


//    public Dog(double weight) {
//        this.weight = weight;
//    }

    public void aboutMe(){
        System.out.println("GAF-GAF, my name's " + name + " weight : " + weight);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;;
        if(!(obj instanceof Dog)) return false;

        Dog dog = (Dog)obj;
        if(weight != dog.weight)    return false;
        return Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {
        return (int)weight+name.hashCode();
    }

    //***************************************GETTERS&SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
