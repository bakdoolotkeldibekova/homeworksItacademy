package hw38;

import java.util.Random;

public class Cat {
    Random rand = new Random();
    private boolean result;

    boolean isCatchUp(){
        result = (rand.nextInt(2) == 0);
        return result;
    }

    void eatTheMouse(){
        System.out.println("eat the mouse");
    }

    void drinkMilk(){
        System.out.println("drink milk");
    }

    @Override
    public String toString() {
        if(result) return "eat";
        return "drink";
    }
}
