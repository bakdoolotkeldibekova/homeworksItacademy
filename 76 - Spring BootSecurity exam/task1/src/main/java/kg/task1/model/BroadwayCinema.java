package kg.task1.model;

public class BroadwayCinema {
    private String name;
    private Integer capacity;
    private String address;
    private String site;

    @Override
    public String toString() {
        return "BroadwayCinema{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", address='" + address + '\'' +
                ", site='" + site + '\'' +
                '}';
    }
}
