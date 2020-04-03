package kg;

import kg.db.AutomobileDB;
import kg.entities.Automobile;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        for (int i=0; i<10; i++){
            Automobile automobile = new Automobile("car"+(i+1), 2000+i);
            AutomobileDB.create(automobile);
        }

        AutomobileDB.getAll().stream().forEach(x -> System.out.println(x));

        Automobile automobile = new Automobile();
        automobile.setId(1);
        automobile.setYear(1990);
        automobile.setModel("tayota");
        AutomobileDB.update(automobile);

        AutomobileDB.deleteById(5);
    }
}
