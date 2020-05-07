package kg.task2.service;

import kg.task2.entity.Student;
import kg.task2.model.StudentModel;
import kg.task2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student create(StudentModel studentModel) {
        Student student = new Student();
        student.setFio(studentModel.getFio());
        student.setContractAmount(studentModel.getContractAmount());
        student.setCourse(studentModel.getCourse());
        student.setDateOfRegistration(LocalDateTime.now());
        return studentRepository.save(student);
    }

    @Override
    public Student deleteById(Long id) {
        Student student = getById(id);
        studentRepository.deleteById(id);
        return student;
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getAllByFio(String fio) {
        return studentRepository.findAllByFioIgnoringCase(fio);
    }
}
