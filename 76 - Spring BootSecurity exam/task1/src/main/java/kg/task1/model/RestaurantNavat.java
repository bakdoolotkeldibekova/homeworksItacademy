package kg.task1.model;

public class RestaurantNavat {
    private String name;
    private String address;
    private String SpecialtyOfTheHouse;
    private String site;

    @Override
    public String toString() {
        return "RestaurantNavat{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", SpecialtyOfTheHouse='" + SpecialtyOfTheHouse + '\'' +
                ", site='" + site + '\'' +
                '}';
    }
}
