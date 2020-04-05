package kg.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
@Table(name = "championship")
public class Championship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "sport_id", nullable = false)
    private Sport sport;

    public Championship(String name, Country country, Sport sport) {
        this.name = name;
        this.country = country;
        this.sport = sport;
    }

    @Override
    public String toString() {
        return "Championship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", sport=" + sport +
                '}';
    }
}
