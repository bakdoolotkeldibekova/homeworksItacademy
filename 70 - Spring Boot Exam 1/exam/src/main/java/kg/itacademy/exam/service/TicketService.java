package kg.itacademy.exam.service;

import kg.itacademy.exam.entity.Ticket;

import java.util.List;

public interface TicketService {
    Ticket create(Ticket ticket);
    Ticket getById(Long id);

    List<Ticket> getAllByIsBoughtAndCinemaPassword(Boolean isBought, String password);

}
