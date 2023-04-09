package miu.edu.lab4.service;

import miu.edu.lab4.domain.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    public Iterable<Comment>findALl();
    public Comment findById(long id);
    public void save(Comment comment);
    public void delete(long id);
    public void update(long id, Comment comment);
}
