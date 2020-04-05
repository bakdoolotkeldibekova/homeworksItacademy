package kg.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
@Table(name = "employee")
public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "age", nullable = false)
        private Integer age;

        @ManyToOne
        @JoinColumn(name = "department_id")
        private Department department;

        @Column(name = "salary")
        private Integer salary;

        @ManyToOne
        @JoinColumn(name = "country_id")
        private Country country;

        public Employee(String name, Integer age, Department department, Integer salary, Country country) {
            this.name = name;
            this.age = age;
            this.department = department;
            this.salary = salary;
            this.country = country;
        }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                ", salary=" + salary +
                ", country=" + country +
                '}';
    }
}
