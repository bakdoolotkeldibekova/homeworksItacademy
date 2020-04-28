package itacademy1.Spring.Security.Intro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "task")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "text", nullable = false)
    private String text;
    @Column(name = "is_done", nullable = false)
    private Boolean isDone;

    public Task(String title, String text, Boolean isDone) {
        this.title = title;
        this.text = text;
        this.isDone = isDone;
    }
}
