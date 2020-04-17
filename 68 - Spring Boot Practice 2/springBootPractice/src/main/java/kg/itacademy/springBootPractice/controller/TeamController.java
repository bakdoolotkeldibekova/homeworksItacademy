package kg.itacademy.springBootPractice.controller;

import kg.itacademy.springBootPractice.entity.Team;
import kg.itacademy.springBootPractice.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping
    public Team create(@RequestBody Team team){
        return teamService.create(team);
    }

    @GetMapping
    public List<Team> getAll(){
        return teamService.getAll();
    }
}
