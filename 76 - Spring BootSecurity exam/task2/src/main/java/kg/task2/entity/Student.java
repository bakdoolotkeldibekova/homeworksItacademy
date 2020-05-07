package kg.task2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fio", nullable = false)
    private String fio;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @Column(name = "date_of_registration")
    private LocalDateTime dateOfRegistration;
    @Column(name = "contract_amount")
    private Integer contractAmount;
}
