package miu.edu.lab5.springsecurity.service;

import miu.edu.lab5.springsecurity.entity.Role;
import miu.edu.lab5.springsecurity.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User saveUser(User user);
//    Role saveRole(Role role);
//    void AddRoleToUser(Role role);
    List<User> getUsers();
    User getUser(String username);
    User getUserById(int id);
    public void addRoleToUser(String username, String rolename);

}
