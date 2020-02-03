package hw38;

import java.util.LinkedList;

public class Task5 {
    public static void main(String[] args) {

        Me Bagdash = new Me();

        LinkedList<Dishes> dishes = new LinkedList<>();
        dishes.add(new Dishes(true, 50));
        dishes.add(new Dishes(false, 60));     //автоматом price = 0; (бесплатный)
        dishes.add(new Dishes(true, 70));


        Bagdash.eat(2, dishes);
    }
}
