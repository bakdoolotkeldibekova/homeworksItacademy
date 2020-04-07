package kg.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "publication_date", nullable = false)
    private LocalDateTime publicationDate;

    @OneToMany
    @JoinColumn(name = "post_like_id")
    private List<PostLike> postLikes;

    public Post(String description, LocalDateTime publicationDate, List<PostLike> postLikes) {
        this.description = description;
        this.publicationDate = publicationDate;
        this.postLikes = postLikes;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", publicationDate=" + publicationDate +
                ", postLike=" + postLikes +
                '}';
    }
}
