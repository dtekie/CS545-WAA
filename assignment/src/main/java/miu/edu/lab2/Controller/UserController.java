package miu.edu.lab2.Controller;

import miu.edu.lab2.Domain.Post;
import miu.edu.lab2.Domain.User;
import miu.edu.lab2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    //@Autowired
    UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
//a Get  localhost:8080/users -> This should retrieve all the users in the database
    @GetMapping
    public List<User> getAll(){
        return userService.findAll();
    }
//a Get  localhost:8080/users/1 -> This should retrieve the user with id 1
    @GetMapping("/{id}")
    public User getByID(@PathVariable("id") long id){
        return userService.getById(id);
    }
    //c.	POST	localhost:8080/users -> This should create and save a new user.
    @PostMapping
    public void create(@RequestBody User user){
        userService.save(user);
    }
//    d.	GET	localhost:8080/users/1/posts -> This should retrieve the posts of the user where id = 1.
    @GetMapping("/{id}/posts")
    public List<Post> getPosts(@PathVariable("id") long id){
        return userService.findPosts(id);
    }

}

