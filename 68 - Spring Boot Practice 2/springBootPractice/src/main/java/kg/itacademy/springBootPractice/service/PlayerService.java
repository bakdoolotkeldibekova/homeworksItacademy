package kg.itacademy.springBootPractice.service;

import kg.itacademy.springBootPractice.entity.Player;

import java.util.List;

public interface PlayerService {
    Player create(Player player);
    Player getByName(String name);
    List<Player> getAllByNameContaining(String string);
    List<Player> getAllByTeamId(Long id);
    List<Player> getAllByStatusAndAgeLessThan(String status, Integer age);
    Player update(Player player);
}
