package kg.task2.controller;

import kg.task2.entity.Student;
import kg.task2.model.StudentModel;
import kg.task2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student create(StudentModel studentModel){
        return studentService.create(studentModel);
    }

    @DeleteMapping
    public Student deleteById(Long id){
        return studentService.deleteById(id);
    }

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/fio")
    public List<Student> getAllByFio(@RequestParam(name = "fio") String fio){
        return studentService.getAllByFio(fio);
    }
}
