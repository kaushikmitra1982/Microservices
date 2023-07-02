package techworld.spring.boot.crud.springbootcrudapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first" , nullable = false)
    private String firstName;
    @Column(name="last" , nullable = false)
    private String lastName;
    @Column(name = "email",nullable = false)
    private String email;

}
