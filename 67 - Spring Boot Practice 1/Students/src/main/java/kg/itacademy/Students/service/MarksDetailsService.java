package kg.itacademy.Students.service;

import kg.itacademy.Students.entity.MarksDetails;

import java.util.List;

public interface MarksDetailsService {
    List<MarksDetails> getAll();
    List<MarksDetails> getBySubject(String subject);
    List<MarksDetails> getByIsPassed(Boolean isPassed);
    List<MarksDetails> getByStudentId(Long id);
    MarksDetails create(MarksDetails marksDetails);
    MarksDetails update(MarksDetails marksDetails);
    void deleteById(Long id);
}
