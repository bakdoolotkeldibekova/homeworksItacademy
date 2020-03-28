import com.company.L60.hw.Juice;
import com.company.L60.hw.Liquid;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void transfuseLiquid(List<? extends Liquid> liquids){
        for(Liquid l : liquids){
            l.transfuse();
        }
    }
    
    public static void main(String[] args) {
    
       Juice juice1 = new Juice();
       Juice juice2 = new Juice();

       List<Juice> juices = new ArrayList<>();
       juices.add(juice1);
       juices.add(juice2);

       transfuseLiquid(juices);

    }
}
