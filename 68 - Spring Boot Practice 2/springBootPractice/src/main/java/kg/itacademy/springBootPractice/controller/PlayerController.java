package kg.itacademy.springBootPractice.controller;

import kg.itacademy.springBootPractice.entity.Player;
import kg.itacademy.springBootPractice.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player") //localhost:8080/player
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping
    public Player create(@RequestBody Player player){
        return playerService.create(player);
    }

    @GetMapping("/name/{name}")
    public Player getByName(@PathVariable String name){
        return playerService.getByName(name);
    }

    @GetMapping("/nameContains/{string}")
    public List<Player> getAllByNameContaining(@PathVariable String string){
        return playerService.getAllByNameContaining(string);
    }

    @GetMapping("/teamId/{id}")
    public List<Player> getAllByTeamId(@PathVariable Long id){
        return playerService.getAllByTeamId(id);
    }

    @GetMapping("/status/{status}/age/{age}")
    public List<Player> getAllByStatusAndAgeLessThan(@PathVariable String status,@PathVariable Integer age){
        return playerService.getAllByStatusAndAgeLessThan(status, age);
    }

    @PutMapping
    public Player update(@RequestBody Player player){
        return playerService.update(player);
    }

}
