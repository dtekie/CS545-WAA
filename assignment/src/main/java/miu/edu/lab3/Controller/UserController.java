package miu.edu.lab3.Controller;


import lombok.AllArgsConstructor;
import miu.edu.lab3.Domain.User;
import miu.edu.lab3.Dto.UserDto;
import miu.edu.lab3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @PutMapping
    public @ResponseBody void updateUser(int id, UserDto userDto){
        userService.updateUser(id, userDto);
    }

    @PostMapping
    public @ResponseBody void addNewUser(User user) {
        userService.saveUser(user);
    }

    @GetMapping("/title{title}")
    public List<User> getUserTitle(@PathVariable String title) {
        return (List<User>) userService.findUserTitle(title);
    }

    @GetMapping("/userPost{n}")
    public List<User> getUserHaveMoreThanOnePost(@PathVariable int n) {
        return userService.findUserHaveMoreThanOnePost(n);
    }

}
