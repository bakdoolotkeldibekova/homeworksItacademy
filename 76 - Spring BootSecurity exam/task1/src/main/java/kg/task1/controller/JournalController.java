package kg.task1.controller;

import kg.task1.entity.Journal;
import kg.task1.model.BroadwayCinema;
import kg.task1.model.RestaurantNavat;
import kg.task1.model.TicketonTickets;
import kg.task1.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/book")
public class JournalController {
    @Autowired
    private JournalService journalService;

    @GetMapping("/R")
    public RestaurantNavat getR(){
        Journal journal = new Journal();
        journal.setCode("R");
        journal.setLocalDateTime(LocalDateTime.now());
        journalService.create(journal);
        return new RestaurantNavat();
    }

    @GetMapping("/C")
    public BroadwayCinema getC(){
        Journal journal = new Journal();
        journal.setCode("C");
        journal.setLocalDateTime(LocalDateTime.now());
        journalService.create(journal);
        return new BroadwayCinema();
    }

    @GetMapping("/T")
    public TicketonTickets getT(){
        Journal journal = new Journal();
        journal.setCode("T");
        journal.setLocalDateTime(LocalDateTime.now());
        journalService.create(journal);
        return new TicketonTickets();
    }

    @GetMapping
    public List<Journal> getAll(){
        return journalService.getAll();
    }

}
