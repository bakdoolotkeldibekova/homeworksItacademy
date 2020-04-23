package kg.itacademy.exam.controller;

import kg.itacademy.exam.entity.Session;
import kg.itacademy.exam.service.SessionSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session") //localhost:8080/session
public class SessionController {
    @Autowired
    private SessionSevice sessionSevice;

    @PostMapping
    public Session create(@RequestBody Session session){
        return sessionSevice.create(session);
    }

    @GetMapping("/{cinemaId}")
    public List<Session> getAllByCinemaId(@PathVariable Long cinemaId){
        return sessionSevice.getAllByCinemaId(cinemaId);
    }

    @GetMapping("/3D/{cinemaId}")
    public List<Session> getAllByIs3DAndCinemaId(@RequestBody Boolean isTrue, @PathVariable Long cinemaId){
        return sessionSevice.getAllByIs3DCinemaId(isTrue, cinemaId);
    }

    @GetMapping("/filmName/{filmName}")
    public List<Session> getAllByFilmName(@PathVariable String filmName){
        return sessionSevice.getAllByFilmName(filmName);
    }

}
