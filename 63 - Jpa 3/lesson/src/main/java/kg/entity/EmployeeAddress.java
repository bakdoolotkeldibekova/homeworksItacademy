package kg.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
@Table(name = "employee_address")
public class EmployeeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "address", nullable = false)
    private String address;

    public EmployeeAddress(Employee employee, String address) {
        this.employee = employee;
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "id=" + id +
                ", employee=" + employee +
                ", address='" + address + '\'' +
                '}';
    }
}
