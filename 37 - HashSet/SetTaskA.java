package hw38;

import java.util.*;

public class SetTaskA {
    public static void main(String[] args) {
        Random rand = new Random();
        Set<Dog> dogs = new HashSet<>();

        for(int i=0; i<40; i++){
            dogs.add(new Dog("Simba", 1+rand.nextInt(15)));
        }

        System.out.println(dogs.size());

        for(Iterator<Dog> iterator = dogs.iterator(); iterator.hasNext();){
            iterator.next().aboutMe();
        }

    }
}
