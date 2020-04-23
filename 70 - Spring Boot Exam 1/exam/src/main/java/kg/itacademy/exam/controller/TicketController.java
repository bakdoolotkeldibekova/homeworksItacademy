package kg.itacademy.exam.controller;

import kg.itacademy.exam.entity.Ticket;
import kg.itacademy.exam.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket){
        return ticketService.create(ticket);
    }

    @GetMapping("/{password}")
    public List<Ticket> getAllByIsBoughtAndCinemaPassword(@RequestBody Boolean isBought,@PathVariable String password){
        return ticketService.getAllByIsBoughtAndCinemaPassword(isBought, password);
    }


}
