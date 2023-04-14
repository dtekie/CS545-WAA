package miu.edu.lab5.springsecurity.controller;

import miu.edu.lab5.springsecurity.entity.Post;
import miu.edu.lab5.springsecurity.entity.User;
import miu.edu.lab5.springsecurity.service.UserService;
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
        return (List<User>) userService.getUsers();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }
    @PostMapping
    public void create(@RequestBody User user){
        userService.saveUser(user);
    }
//    @GetMapping("/{id}/posts")
//    public List<Post> getPosts(@PathVariable ("id") long id){
//    return userService.findPosts(id);
//    }


}
