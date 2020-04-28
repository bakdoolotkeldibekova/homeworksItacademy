package itacademy1.Spring.Security.Intro.repository;


import itacademy1.Spring.Security.Intro.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByTitleContainingIgnoringCase(String title);
    List<Task> findAllByTextContainingIgnoringCase(String text);
}
