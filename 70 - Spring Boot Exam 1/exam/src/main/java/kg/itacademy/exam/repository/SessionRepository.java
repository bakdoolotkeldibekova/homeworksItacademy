package kg.itacademy.exam.repository;

import kg.itacademy.exam.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findAllByCinema_Id(Long cinemaId);
    List<Session> findAllByIs3DAndCinema_Id(Boolean is3D, Long cinemaId);
  //  List<Session> findAllByDateAndTimeBetweenAndCinema_Id(LocalDateTime from, LocalDateTime to, Long cinemaId);
    List<Session> findAllByFilm_NameIgnoringCase(String filmName);
}
