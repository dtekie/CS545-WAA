package miu.edu.lab4.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long id;
    String title;
    String content;
    String author;
    @OneToMany(cascade = CascadeType.ALL)
            @JoinColumn(name="post_id")
    List<Comment> commentList;


}

