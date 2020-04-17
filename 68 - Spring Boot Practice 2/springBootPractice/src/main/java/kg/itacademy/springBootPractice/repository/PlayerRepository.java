package kg.itacademy.springBootPractice.repository;

import kg.itacademy.springBootPractice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByNameIgnoringCase(String name);
    List<Player> findAllByNameContaining(String string);
    List<Player> findAllByTeam_Id(Long id);
    List<Player> findAllByStatusAndAgeLessThan(String status, Integer age);
}
