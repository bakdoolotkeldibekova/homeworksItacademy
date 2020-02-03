package hw38;

import java.util.LinkedList;

public class Task4 {
    public static void main(String[] args) {
        LinkedList<Cat> catList = new LinkedList<>();

        for(int i=0; i<100; i++){
            Cat cat = new Cat();
            if(cat.isCatchUp()){
                cat.eatTheMouse();
                catList.addFirst(cat);
            }
            else{
                cat.drinkMilk();
                catList.addLast(cat);
            }
        }

        System.out.println(catList);

    }
}
