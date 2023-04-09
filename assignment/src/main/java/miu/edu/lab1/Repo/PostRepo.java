package miu.edu.lab1.Repo;


import miu.edu.lab1.Domain.Post;

import java.util.List;

public interface PostRepo  {
    public List<Post> findAll();
    public Post findById(long id);
    public void save(Post post);
    public void delete(long id);
    public void update(long id, Post post);
    public List<Post>findPostByAuthor(String author);

}
