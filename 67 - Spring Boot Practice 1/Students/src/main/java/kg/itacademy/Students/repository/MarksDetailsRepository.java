package kg.itacademy.Students.repository;

import kg.itacademy.Students.entity.MarksDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksDetailsRepository extends JpaRepository<MarksDetails, Long> {
}
