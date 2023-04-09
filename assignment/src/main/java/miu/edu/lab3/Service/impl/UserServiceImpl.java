package miu.edu.lab3.Service.impl;


import miu.edu.lab3.Domain.Comment;
import miu.edu.lab3.Domain.Post;
import miu.edu.lab3.Domain.User;
import miu.edu.lab3.Dto.UserDto;
import miu.edu.lab3.Repo.CommentRepo;
import miu.edu.lab3.Repo.PostRepo;

import miu.edu.lab3.Repo.UserRepo;
import miu.edu.lab3.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
@Autowired
    UserRepo userRepo;

@Autowired
    PostRepo postRepo;

@Autowired
    CommentRepo commentRepo;

@Autowired
    ModelMapper modelMapper;



    @Override
    public List<User> getAllUsers() {

        List<User> users = (List<User>) userRepo.findAll();

        for (User user: users){
            List<Post> posts = (List<Post>) postRepo.findAll();
            for (Post post: posts){
                Iterable<Comment> comments =  commentRepo.findAll();
                post.setComments((List<Comment>) comments);
            }
            user.setPosts(posts);
        }
        return users;
    }



    @Override
    public User getUserById(long id) {

        var user = userRepo.findById(id).orElseThrow(IllegalArgumentException::new);
        var po = postRepo.findById(id).orElseThrow(IllegalArgumentException::new);
        var co = commentRepo.findById(id).orElseThrow(IllegalArgumentException::new);
        user.setPosts((List<Post>) po);
        po.setComments((List<Comment>) co);
        return user;

    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }


    @Override
    public void updateUser(long id, UserDto userDto) {
        User user = userRepo.findById(id).orElseThrow();
        user.setName(userDto.getName());
        user.setPosts(userDto.getPosts());
        userRepo.save(user);
    }


    @Override
    public void deleteUser(long id) {
        
        userRepo.deleteById(id);
    }


    public List<User> findUserTitle(String title){
        var user = userRepo.getTitle(title);
        return (List<User>) user;
    }

    @Override
    public List<User> findUserHaveMoreThanOnePost(int n) {
        return userRepo.findUserByPostsGreaterThan(n);
    }


}
