package kg.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor

@Entity
@Table(name = "post_like")
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "liked_date", nullable = false)
    private LocalDateTime likedDate;

    public PostLike(LocalDateTime likedDate) {
        this.likedDate = likedDate;
    }

    @Override
    public String toString() {
        return "PostLike{" +
                "id=" + id +
                ", likedDate=" + likedDate +
                '}';
    }
}
