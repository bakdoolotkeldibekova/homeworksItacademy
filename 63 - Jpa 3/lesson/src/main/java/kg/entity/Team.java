package kg.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "logo_address", nullable = false)
    private String logoAddress;

    @Column(name = "website", nullable = false)
    private String website;

    @ManyToOne
    @JoinColumn(name = "sport_id", nullable = false)
    private Sport sport;

    public Team(String name, String logoAddress, String website, Sport sport) {
        this.name = name;
        this.logoAddress = logoAddress;
        this.website = website;
        this.sport = sport;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logoAddress='" + logoAddress + '\'' +
                ", website='" + website + '\'' +
                ", sport=" + sport +
                '}';
    }
}
