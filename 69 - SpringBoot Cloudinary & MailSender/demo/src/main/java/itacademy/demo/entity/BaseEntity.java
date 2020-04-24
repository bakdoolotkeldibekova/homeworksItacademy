package itacademy.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    @PrePersist
    public void persistCreate(){
        this.dateCreated = LocalDateTime.now();
    }

    @PreUpdate
    public void persistUpdate(){
        this.dateUpdated = LocalDateTime.now();
    }


}
