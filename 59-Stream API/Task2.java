import java.util.*;

public class Task2 {
    public static void main(String[] args){
    
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "one");
        hashMap.put(2, "two");
        hashMap.put(3, "three");
        hashMap.put(4, "four");
        hashMap.put(5, "five");
        hashMap.put(6, "six");
        hashMap.put(7, "seven");
        hashMap.put(8, "eighttt");
        hashMap.put(9, "nine");
        hashMap.put(10, "ten");

        hashMap.entrySet().stream()
                .filter(x -> x.getKey() > 5).forEach(x -> {
                    if(x.getKey()%3 == 0){
                        System.out.println(x + ", ");
                    }
                    else {
                        System.out.println(x);
                    }
        });

        Integer multiply = hashMap.entrySet().stream()
                .filter(x -> x.getValue().length() > 5).mapToInt(x -> x.getKey()).reduce(1, (x, y) -> x * y);
        System.out.println(multiply);

    }
}
