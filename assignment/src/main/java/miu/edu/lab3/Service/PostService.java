package miu.edu.lab3.Service;

import miu.edu.lab3.Domain.Post;
import miu.edu.lab3.Dto.PostDto;

import java.util.List;


public interface PostService  {

    List<Post> getAll();
    Post getById(long id);
    public void save(Post postDto);
//    void saveDto(Post postDto);

    void delete(long id);

    void update(long id, PostDto postDto);

    public List<Post> findPostTitle(String title);
}
