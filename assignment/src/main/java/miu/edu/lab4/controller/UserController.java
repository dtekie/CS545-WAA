package miu.edu.lab4.controller;

import miu.edu.lab4.domain.User;
import miu.edu.lab4.domain.Post;
import miu.edu.lab4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable("id") long id){
        return userService.getByID(id);
    }
    @PostMapping
    public void create(@RequestBody User user){
        userService.save(user);
    }
    @GetMapping("/{id}/posts")
    public List<Post> getPosts(@PathVariable ("id") long id){
    return userService.findPosts(id);
    }


}
