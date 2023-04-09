package miu.edu.lab3.Domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private String author;

     @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     @JoinColumn(name = "comments")
     private List<Comment> comments;

}
