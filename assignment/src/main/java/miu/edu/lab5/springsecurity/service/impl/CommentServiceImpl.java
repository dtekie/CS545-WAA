package miu.edu.lab5.springsecurity.service.impl;

import miu.edu.lab5.springsecurity.entity.Comment;
import miu.edu.lab5.springsecurity.repository.CommentRepo;
import miu.edu.lab5.springsecurity.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;
    @Override
    public Iterable<Comment> findALl() {
        return commentRepo.findAll();
    }

    @Override
    public Comment findById(long id) {
        return commentRepo.findById(id).get();
    }

    @Override
    public void save(Comment comment) {
        commentRepo.save(comment);

    }

    @Override
    public void delete(long id) {
        commentRepo.deleteById(id);

    }

    @Override
    public void update(long id, Comment comment) {
        commentRepo.updateIdBy(id);

    }
}
