package kg.itacademy.Students.controller;

import kg.itacademy.Students.entity.MarksDetails;
import kg.itacademy.Students.service.MarksDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marksDetails")
public class MarksDetailsController {
    @Autowired
    private MarksDetailsService marksDetailsService;

    @GetMapping
    public List<MarksDetails> getAll(){
        return marksDetailsService.getAll();
    }

    @GetMapping("/subject_"+"{subject}")
    public List<MarksDetails> getBySubject(@PathVariable String subject){
        return marksDetailsService.getBySubject(subject);
    }

    @GetMapping("/isPassed_"+"{isPassed}")
    public List<MarksDetails> getByIsPassed(@PathVariable Boolean isPassed){
        return marksDetailsService.getByIsPassed(isPassed);
    }

    @GetMapping("/studentId_"+"{studentId}")
    public List<MarksDetails> getByStudentId(@PathVariable Long studentId){
        return marksDetailsService.getByStudentId(studentId);
    }

    @PostMapping
    public MarksDetails create(@RequestBody MarksDetails marksDetails){
        return marksDetailsService.create(marksDetails);
    }

    @PutMapping
    public MarksDetails update(@RequestBody MarksDetails marksDetails){
        return marksDetailsService.update(marksDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        marksDetailsService.deleteById(id);
    }

}
