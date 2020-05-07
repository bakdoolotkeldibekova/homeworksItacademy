package kg.task2.service;

import kg.task2.entity.Student;
import kg.task2.model.StudentModel;

import java.util.List;

public interface StudentService {
    Student create(StudentModel studentModel);
    Student deleteById(Long id);
    Student getById(Long id);
    List<Student> getAll();

    List<Student> getAllByFio(String fio);
}
