package miu.edu.lab5.springsecurity.controller;

import miu.edu.lab5.springsecurity.entity.Comment;
import miu.edu.lab5.springsecurity.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping
    public List<Comment> getAllComments(){
        return (List<Comment>) commentService.findALl();
    }
    @GetMapping("/{id}")
    public Comment findById(long id){
        return commentService.findById(id);
    }
    @PostMapping
    public void create(@RequestBody Comment comment){
        commentService.save(comment);
    }
    @PutMapping("/id")
    public void update(@PathVariable("id") long id, Comment comment){
        commentService.update(id, comment);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        commentService.delete(id);
    }

}
