package kg.itacademy.Students.controller;

import kg.itacademy.Students.entity.Student;
import kg.itacademy.Students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student") // localhost:8080/student
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id){
        return studentService.getById(id);
    }

    @PostMapping
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }

    @PutMapping
    public Student update(@RequestBody Student student){
        return studentService.update(student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        studentService.deleteById(id);
    }
}
