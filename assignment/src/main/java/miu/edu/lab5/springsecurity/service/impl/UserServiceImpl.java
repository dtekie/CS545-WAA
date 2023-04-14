package miu.edu.lab5.springsecurity.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.lab5.springsecurity.entity.Role;
import miu.edu.lab5.springsecurity.entity.User;
import miu.edu.lab5.springsecurity.repository.UserRepo;
import miu.edu.lab5.springsecurity.repository.RoleRepo;
import miu.edu.lab5.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service @RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }
    public Role saveRole(Role role){
        return roleRepo.save(role);
    }


    @Override
    public List<User> getUsers() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByRolename(rolename);
        user.getRoles().add(role);
    }
}





