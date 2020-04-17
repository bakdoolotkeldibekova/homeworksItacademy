package kg.itacademy.springBootPractice.service;

import kg.itacademy.springBootPractice.entity.Team;
import kg.itacademy.springBootPractice.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Override
    public Team create(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public List<Team> getAll() {
        return teamRepository.findAll();
    }
}
