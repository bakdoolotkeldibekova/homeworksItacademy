package kg.itacademy.exam.service;

import kg.itacademy.exam.entity.Ticket;
import kg.itacademy.exam.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket create(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ticket> getAllByIsBoughtAndCinemaPassword(Boolean isBought, String password) {
        return ticketRepository.findAllByIsBoughtAndSession_Cinema_Password(isBought, password);
    }
}
