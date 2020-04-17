package kg.itacademy.springBootPractice.service;

import kg.itacademy.springBootPractice.entity.Team;

import java.util.List;

public interface TeamService {
    Team create(Team team);
    List<Team> getAll();
}
