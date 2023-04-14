package miu.edu.lab5.springsecurity.service;

import miu.edu.lab5.springsecurity.entity.Comment;
import org.springframework.stereotype.Service;


@Service
public interface CommentService {
    public Iterable<Comment>findALl();
    public Comment findById(long id);
    public void save(Comment comment);
    public void delete(long id);
    public void update(long id, Comment comment);
}
