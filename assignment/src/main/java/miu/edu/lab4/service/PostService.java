package miu.edu.lab4.service;

import miu.edu.lab4.domain.Comment;
import miu.edu.lab4.domain.Post;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    public List<Post> findAll();
    public Post getById(long id);
    public void save(Post post);
    public void delete(long id);
    public void update(long id, Post post);
    public List<Comment> findComments(long id);
    public void addComments(long id, Comment comment);
    public List<Post> findPostByTitle(@Param("title") String title);

}
