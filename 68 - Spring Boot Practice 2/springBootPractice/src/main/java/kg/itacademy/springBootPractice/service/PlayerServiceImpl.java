package kg.itacademy.springBootPractice.service;

import kg.itacademy.springBootPractice.entity.Player;
import kg.itacademy.springBootPractice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player create(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getByName(String name) {
        return playerRepository.findByNameIgnoringCase(name);
    }

    @Override
    public List<Player> getAllByNameContaining(String string) {
        return playerRepository.findAllByNameContaining(string);
    }

    @Override
    public List<Player> getAllByTeamId(Long id) {
        return playerRepository.findAllByTeam_Id(id);
    }

    @Override
    public List<Player> getAllByStatusAndAgeLessThan(String status, Integer age) {
        return playerRepository.findAllByStatusAndAgeLessThan(status, age);
    }

    @Override
    public Player update(Player player) {
        return playerRepository.save(player);
    }
}
