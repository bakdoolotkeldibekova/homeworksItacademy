package kg.itacademy.exam.service;

import kg.itacademy.exam.entity.Session;
import kg.itacademy.exam.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionSeviceImpl implements SessionSevice {
    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public Session create(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public List<Session> getAllByCinemaId(Long cinemaId) {
        return sessionRepository.findAllByCinema_Id(cinemaId);
    }

    @Override
    public List<Session> getAllByIs3DCinemaId(Boolean is3D, Long cinemaId) {
        return sessionRepository.findAllByIs3DAndCinema_Id(is3D, cinemaId);
    }

    @Override
    public List<Session> getAllByFilmName(String filmName) {
        return sessionRepository.findAllByFilm_NameIgnoringCase(filmName);
    }
}
