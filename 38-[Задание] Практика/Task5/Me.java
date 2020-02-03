package hw38;

import java.util.LinkedList;

public class Me {

    void eat(int whichTime, LinkedList<Dishes> dishesLinkedList){
        if(whichTime == 2){
            int sum=0;
            for (Dishes d : dishesLinkedList) {
                sum += d.getPrice();
            }
            System.out.println("Lunch time! this is you foodCost: " + sum);
        }
        else if(whichTime == 1 || whichTime == 3)
            System.out.println("not Lunch time. not need a foodCost");
        else
            System.out.println("ERROR, I cat eat only three times!");

    }

}
