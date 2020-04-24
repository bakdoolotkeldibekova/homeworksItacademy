package itacademy.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;

}
