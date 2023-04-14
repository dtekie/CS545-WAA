package miu.edu.lab5.springsecurity.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;
}
