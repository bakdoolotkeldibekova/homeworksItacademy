package kg;

import kg.db.ChampionshipDB;
import kg.db.GenericsDB;
import kg.db.TeamDB;
import kg.entity.Championship;
import kg.entity.Country;
import kg.entity.Sport;
import kg.entity.Team;

public class App {
    public static void main(String[] args) {

        //task1 ----------------------------------------------------------------------------------
//        Country kyrgyzstan = new Country("Kyrgyzstan");
//        Country uzbekistan = new Country("Uzbekistan");
//        Country russia = new Country("Russia");
//        GenericsDB<Country> countryDB = new GenericsDB<>();
//        countryDB.create(kyrgyzstan);
//        countryDB.create(uzbekistan);
//        countryDB.create(russia);
//
//        Department department1 = new Department("Security");
//        Department department2 = new Department("IT");
//        GenericsDB<Department> departmentDB = new GenericsDB<>();
//        departmentDB.create(department1);
//        departmentDB.create(department2);
//
//        Employee employee1 = new Employee("Alex", 30, department2, 600, kyrgyzstan);
//        Employee employee2 = new Employee("Ann", 19, department1, 500, uzbekistan);
//        Employee employee3 = new Employee("Max", 20, department2, 600, kyrgyzstan);
//        Employee employee4 = new Employee("Fedor", 16, department2, 1100, russia);
//        GenericsDB<Employee> employeeDB = new GenericsDB<>();
//        employeeDB.create(employee1);
//        employeeDB.create(employee2);
//        employeeDB.create(employee3);
//        employeeDB.create(employee4);
//
//        System.out.println("[Отсортировать по ФИО]:");
//        List<Employee> employeeListOrderByName = EmployeeDB.getAllOrderByNameASC();
//        employeeListOrderByName.stream().forEach(x -> System.out.println(x));
//
//        System.out.println("\n[Отсортировать по названию страны]:");
//        List<Employee> employeeListOrderByCountryName = EmployeeDB.getAllOrderByCountryName();
//        employeeListOrderByCountryName.stream().forEach(x -> System.out.println(x));
//
//        System.out.println("\n[Отсортировать по названию отдела]:");
//        List<Employee> employeeListOrderByDepartmentName = EmployeeDB.getAllOrderByDepartmentName();
//        employeeListOrderByDepartmentName.stream().forEach(x -> System.out.println(x));


        //task2 ----------------------------------------------------------------------------------
        Country kyrgyzstan = new Country("Kyrgyzstan");
        Country italy = new Country("Italy");
        GenericsDB<Country> countryDB = new GenericsDB<>();
        countryDB.create(kyrgyzstan);
        countryDB.create(italy);

        Sport football = new Sport("football");
        Sport basketball = new Sport("basketball");
        Sport hockey = new Sport("hockey");
        Sport tennis = new Sport("tennis");
        GenericsDB<Sport> sportDB = new GenericsDB<>();
        sportDB.create(football);
        sportDB.create(basketball);
        sportDB.create(hockey);
        sportDB.create(tennis);

        Team team1 = new Team("Manchester United Football Club", "United Kingdom", "Manchester.com", football);
        Team team2 = new Team("Liverpool", "United Kingdom", "Liverpool.com", football);
        Team team3 = new Team("Orthodox", "Jordanian Team", "Orthodoox.com", basketball);
        Team team4 = new Team("Al Riyadi Amman", "Jordanian League", "AlRiyadiAmman.com", hockey);
        Team team5 = new Team("Toronto Maple Leafs", "Toronto", "TorontoHockey.com", hockey);
        Team team6 = new Team("New York Rangers", "NYR", "NewYorkRangers.com", hockey);
        Team team7 = new Team("Boston Bruins", "B.", "BostonBruins.com", hockey);
        Team team8 = new Team("Los Angeles Kings", "Los Angeles", "LosAngelesKings.com", hockey);
        Team team9 = new Team("Blackhawks", "Чика́го Блэ́кхокс", "Blackhawks.com", tennis);
        Team team10 = new Team("Philadelphia Flyers", "Ph.Flyers", "PhiladelphiaFlyers.com", tennis);
        Team team11 = new Team("Tampa Bay Lightning", "Tampa", "TampaLightning.com", tennis);
        Team team12 = new Team("Detroit Red Wings", "Detroit", "DetroitWings.com", tennis);
        GenericsDB<Team> teamDB = new GenericsDB<>();
        teamDB.create(team1);
        teamDB.create(team2);
        teamDB.create(team3);
        teamDB.create(team4);
        teamDB.create(team5);
        teamDB.create(team6);
        teamDB.create(team7);
        teamDB.create(team8);
        teamDB.create(team9);
        teamDB.create(team10);
        teamDB.create(team11);
        teamDB.create(team12);

        Championship championship1 = new Championship("EFL Championship", italy, football);
        Championship championship2 = new Championship("Sky Bet Championship", italy, hockey);
        Championship championship3 = new Championship("World Championship", italy, tennis);
        Championship championship4 = new Championship("World Championship", kyrgyzstan, basketball);
        GenericsDB<Championship> championshipDB = new GenericsDB<>();
        championshipDB.create(championship1);
        championshipDB.create(championship2);
        championshipDB.create(championship3);
        championshipDB.create(championship4);

        //only 10 teams
        TeamDB.getAllOrderBySportName(ChampionshipDB.getSportsByCountry(italy)).stream().forEach(x -> System.out.println(x));

    }
}
