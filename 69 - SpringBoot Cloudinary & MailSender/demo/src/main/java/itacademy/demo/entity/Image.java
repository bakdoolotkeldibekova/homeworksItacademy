package itacademy.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "image")
public class Image extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "format", nullable = false)
    private String format;
    @Column(name = "url", nullable = false)
    private String url;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
