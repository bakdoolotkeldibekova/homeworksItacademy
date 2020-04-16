package kg.itacademy.Students.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
@Table(name = "marks_details")
public class MarksDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "subject")
    private String subject;
    @Column(name = "marks_obtained")
    private Integer marksObtained;
    @Column(name = "is_passed")
    private Boolean isPassed;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public MarksDetails(String subject, Integer marksObtained, Student student) {
        this.subject = subject;
        this.marksObtained = marksObtained;
        this.student = student;
        isPassed = this.marksObtained > 55;
    }

    //можно специально пропустить, даже если не прошел (mark<55)
    //так что оставляем setIsPassed()

}
