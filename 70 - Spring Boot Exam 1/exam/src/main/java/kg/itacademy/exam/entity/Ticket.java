package kg.itacademy.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "place_number", nullable = false)
    private String placeNumber;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name = "is_bought", nullable = false)
    private Boolean isBought=false;
    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;
}
