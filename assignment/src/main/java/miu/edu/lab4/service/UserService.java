package miu.edu.lab4.service;

import miu.edu.lab4.domain.User;
import miu.edu.lab4.domain.Post;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> findAll();
    public User getByID(long id);
    public void save(User user);
    public List<Post>findPosts(long id);
    public List<User> findUserByPostsGreaterThan(@Param("n")int n);
}
