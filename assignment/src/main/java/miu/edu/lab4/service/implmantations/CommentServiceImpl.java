package miu.edu.lab4.service.implmantations;

import miu.edu.lab4.domain.Comment;
import miu.edu.lab4.repository.CommentRepo;
import miu.edu.lab4.repository.PostRepo;
import miu.edu.lab4.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    private PostRepo postRepo;

    @Override
    public List<Comment> findALl() {
        return commentRepo.findAll();
    }

    @Override
    public Comment findById(long id) {
        return commentRepo.findById(id).orElse(null);
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
        Comment c= commentRepo.findById(id).orElse(null);
        c.setName(comment.getName());
        commentRepo.save(comment);
    }
}
