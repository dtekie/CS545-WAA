package miu.edu.lab1.Service;


import miu.edu.lab1.Domain.Post;
import miu.edu.lab1.Domain.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<Post> findAll();
   public PostDto findById(long id);
    void save(Post post);
    void delete(long id);
    void update(long id, Post post);
   public List<Post> findPostByAuthor(String author);
}
