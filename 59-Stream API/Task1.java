import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args){
    
        List<Integer> integers = Arrays.asList(1, 2, 3, 5);
        Integer sum = integers.stream().map(i -> i%2==0 ? i:i*(-1)).reduce(0, (x,y) -> x+y);
        System.out.println(sum);

    }
}
