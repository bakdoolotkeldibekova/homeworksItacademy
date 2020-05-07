package kg.task2.model;

import kg.task2.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel {
    private String fio;
    private Course course;
    private Integer contractAmount;
}
