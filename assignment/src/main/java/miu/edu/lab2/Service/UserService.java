package miu.edu.lab2.Service;

import miu.edu.lab2.Domain.Post;
import miu.edu.lab2.Domain.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User getById(long id);
    public void save(User user);
    public List<Post> findPosts(long id);

}
