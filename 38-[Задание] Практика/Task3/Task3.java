package hw38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task3 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Set<Person> personSet = new HashSet<>();

        for(int i=0; i<20; i++){
            Person person = new Person(i, "Nastya"+i);
            if(!personList.contains(person))
                personList.add(person);
            else
                personSet.add(person);

        }
        System.out.println(personList.size());

        for(Person p : personList){
            System.out.println(p.getName());
        }

    }
}
