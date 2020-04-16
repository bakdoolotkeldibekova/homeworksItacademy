package kg.itacademy.Students.service;

import kg.itacademy.Students.entity.MarksDetails;
import kg.itacademy.Students.entity.Student;
import kg.itacademy.Students.repository.MarksDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarksDetailsServiceImpl implements MarksDetailsService {
    @Autowired
    private MarksDetailsRepository marksDetailsRepository;

    @Override
    public List<MarksDetails> getAll() {
        return marksDetailsRepository.findAll();
    }

    @Override
    public List<MarksDetails> getBySubject(String subject) {
        List<MarksDetails> list = marksDetailsRepository.findAll().stream().filter(x -> x.getSubject().equals(subject)).collect(Collectors.toList());
        return list;
    }

    @Override
    public List<MarksDetails> getByIsPassed(Boolean isPassed) {
        List<MarksDetails> list = marksDetailsRepository.findAll().stream().filter(x -> x.getIsPassed()).collect(Collectors.toList());
        return list;
    }

    @Override
    public List<MarksDetails> getByStudentId(Long id) {
        List<MarksDetails> list = marksDetailsRepository.findAll().stream().filter(x -> x.getStudent().getId().equals(id)).collect(Collectors.toList());
        return list;
    }

    @Override
    public MarksDetails create(MarksDetails marksDetails) {
        return marksDetailsRepository.save(marksDetails);
    }

    @Override
    public MarksDetails update(MarksDetails marksDetails) {
        return marksDetailsRepository.save(marksDetails);
    }

    @Override
    public void deleteById(Long id) {
        marksDetailsRepository.deleteById(id);
    }
}
