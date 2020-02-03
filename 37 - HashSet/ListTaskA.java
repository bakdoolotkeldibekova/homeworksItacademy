package hw38;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListTaskA {
    public static void main(String[] args) {
        ArrayList<Cat> arrayList = new ArrayList<Cat>();
        LinkedList<Cat> linkedList = new LinkedList<Cat>();

        for(int i=0; i<1000000; i++){
            arrayList.add(new Cat("arrayBarsik"));
            linkedList.addLast(new Cat("linkedBarsik"));
        }

        LocalDateTime startArray = LocalDateTime.now();
        for(int i=1000000/2; i<(1000000/2)+100; i++){
            arrayList.add(i, new Cat("arrayNewBarsik"));
        }
        LocalDateTime finishArray = LocalDateTime.now();
        double diffArray = startArray.until(finishArray, ChronoUnit.MILLIS);

        LocalDateTime startLinked = LocalDateTime.now();
        for(int i=1000000/2; i<(1000000/2)+100; i++){
            linkedList.add(i, new Cat("linkedNewBarsik"));
        }
        LocalDateTime finishLinked = LocalDateTime.now();
        double diffLinked = startLinked.until(finishLinked, ChronoUnit.MILLIS);

        System.out.println("\nMID addition");
        System.out.println("diffArray = " + diffArray + "\ndiffLinked = " + diffLinked);
        System.out.println(diffArray<diffLinked ? "Quickly array" : "Quickly linked");

        startArray = LocalDateTime.now();
        for(int i=0; i<100; i++){
            arrayList.add(i, new Cat("arrayNewBarsik"));
        }
        finishArray = LocalDateTime.now();
        diffArray = startArray.until(finishArray, ChronoUnit.MILLIS);

        startLinked = LocalDateTime.now();
        for(int i=0; i<100; i++){
            linkedList.add(i, new Cat("linkedNewBarsik"));
        }
        finishLinked = LocalDateTime.now();
        diffLinked = startLinked.until(finishLinked, ChronoUnit.MILLIS);

        System.out.println("\nBEGIN addition");
        System.out.println("diffArray = " + diffArray + "\ndiffLinked = " + diffLinked);
        System.out.println(diffArray<diffLinked ? "Quickly array" : "Quickly linked");

        startArray = LocalDateTime.now();
        for(int i=0; i<100; i++){
            arrayList.add(new Cat("arrayNewBarsik"));
        }
        finishArray = LocalDateTime.now();
        diffArray = startArray.until(finishArray, ChronoUnit.MILLIS);

        startLinked = LocalDateTime.now();
        for(int i=0; i<100; i++){
            linkedList.addLast(new Cat("linkedNewBarsik"));
        }
        finishLinked = LocalDateTime.now();
        diffLinked = startLinked.until(finishLinked, ChronoUnit.MILLIS);

        System.out.println("\nEND addition");
        System.out.println("diffArray = " + diffArray + "\ndiffLinked = " + diffLinked);
        System.out.println(diffArray<diffLinked ? "Quickly array" : "Quickly linked");

        startArray = LocalDateTime.now();
        arrayList.get(arrayList.size()/2);
        finishArray = LocalDateTime.now();
        diffArray = startArray.until(finishArray, ChronoUnit.MILLIS);

        startLinked = LocalDateTime.now();
        linkedList.get(linkedList.size()/2);
        finishLinked = LocalDateTime.now();
        diffLinked = startLinked.until(finishLinked, ChronoUnit.MILLIS);

        System.out.println("\nMID get");
        System.out.println("diffArray = " + diffArray + "\ndiffLinked = " + diffLinked);
        System.out.println(diffArray<diffLinked ? "Quickly array" : "Quickly linked");

        startArray = LocalDateTime.now();
        arrayList.get(arrayList.size()-1);
        finishArray = LocalDateTime.now();
        diffArray = startArray.until(finishArray, ChronoUnit.MILLIS);

        startLinked = LocalDateTime.now();
        linkedList.getLast();
        finishLinked = LocalDateTime.now();
        diffLinked = startLinked.until(finishLinked, ChronoUnit.MILLIS);

        System.out.println("\nEND get");
        System.out.println("diffArray = " + diffArray + "\ndiffLinked = " + diffLinked);
        System.out.println(diffArray<diffLinked ? "Quickly array" : "Quickly linked");

        startArray = LocalDateTime.now();
        arrayList.remove(arrayList.size()/2);
        finishArray = LocalDateTime.now();
        diffArray = startArray.until(finishArray, ChronoUnit.MILLIS);

        startLinked = LocalDateTime.now();
        linkedList.remove(linkedList.size()/2);
        finishLinked = LocalDateTime.now();
        diffLinked = startLinked.until(finishLinked, ChronoUnit.MILLIS);

        System.out.println("\nMID remove");
        System.out.println("diffArray = " + diffArray + "\ndiffLinked = " + diffLinked);
        System.out.println(diffArray<diffLinked ? "Quickly array" : "Quickly linked");

        startArray = LocalDateTime.now();
        arrayList.remove(0);
        finishArray = LocalDateTime.now();
        diffArray = startArray.until(finishArray, ChronoUnit.MILLIS);

        startLinked = LocalDateTime.now();
        linkedList.removeLast();
        finishLinked = LocalDateTime.now();
        diffLinked = startLinked.until(finishLinked, ChronoUnit.MILLIS);

        System.out.println("\nLAST remove");
        System.out.println("diffArray = " + diffArray + "\ndiffLinked = " + diffLinked);
        System.out.println(diffArray<diffLinked ? "Quickly array" : "Quickly linked");

    }

}
