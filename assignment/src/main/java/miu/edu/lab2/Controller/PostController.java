package miu.edu.lab2.Controller;


import miu.edu.lab2.Domain.Post;
import miu.edu.lab2.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")

public class PostController {

//    @Autowired
    private  PostService postService;

    public PostController(PostService postService){

        this.postService=postService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Post> getAll(){

        return postService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody Post p){

        postService.save(p);
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable("id") long id){

        return postService.findById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){

        postService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable ("id") int postId, @RequestBody Post p){
        postService.update(postId,p);
    }


}

