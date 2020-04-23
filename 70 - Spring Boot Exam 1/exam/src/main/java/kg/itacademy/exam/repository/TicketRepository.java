package kg.itacademy.exam.repository;

import kg.itacademy.exam.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByIsBoughtAndSession_Cinema_Password(Boolean isBought, String password);
}
