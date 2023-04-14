package miu.edu.lab5.springsecurity.controller;

import miu.edu.lab5.springsecurity.entity.Comment;
import miu.edu.lab5.springsecurity.entity.Post;
import miu.edu.lab5.springsecurity.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {
    @Autowired
    PostService postService;
    @GetMapping
    public List<Post> getPosts(){
        return postService.findAll();
    }
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable("id") long id){
        return postService.getById(id);
    }
    @PostMapping
    public void create(@RequestBody Post post){
        postService.save(post);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, Post post){
        postService.update(id,post);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id){
        postService.delete(id);
    }
    @GetMapping("/{id}/comments")
    public List<Comment>getCommentById(@PathVariable("id") long id){
        return postService.findComments(id);
    }
    @PostMapping("/{id}/comments")
    public void createComment(@PathVariable long id, @RequestParam Comment comment){
        postService.addComments(id, comment);
    }
    @GetMapping("/{title}")
    public List<Post>getPostByTitle(@PathVariable String title){
        return postService.findPostByTitle(title);
    }


}
