package kg.itacademy.exam.service;

import kg.itacademy.exam.entity.Session;

import java.util.List;

public interface SessionSevice {
    Session create(Session session);
    List<Session> getAllByCinemaId(Long cinemaId);
    List<Session> getAllByIs3DCinemaId(Boolean is3D, Long cinemaId);
    List<Session> getAllByFilmName(String filmName);
}
