package miu.edu.lab5.springsecurity.entity;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String rolename;
}
