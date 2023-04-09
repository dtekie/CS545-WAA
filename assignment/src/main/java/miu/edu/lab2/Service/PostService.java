package miu.edu.lab2.Service;


import miu.edu.lab2.Domain.Post;
import miu.edu.lab2.Domain.dto.PostDto;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(long id);
    void save(Post post);
    void delete(long id);
    void update(long id,Post post);

}
