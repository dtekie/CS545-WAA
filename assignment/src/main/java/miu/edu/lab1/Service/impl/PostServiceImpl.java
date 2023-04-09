package miu.edu.lab1.Service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.lab1.Service.PostService;
import miu.edu.lab1.Domain.Post;
import miu.edu.lab1.Domain.dto.PostDto;
import miu.edu.lab1.Repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
   @Autowired
   PostRepo postRepo;

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public PostDto findById(long id) {
        Post post= postRepo.findById(id);
        return new PostDto(post.getTitle(),post.getContent(),post.getAuthor());
    }

    @Override
    public void save(Post post) {
        postRepo.save(post);
    }

    @Override
    public void delete(long id) {
        postRepo.delete(id);

    }
    @Override
    public void update(long id, Post post) {
        postRepo.update(id, post);
    }

    @Override
    public List<Post> findPostByAuthor(String author) {
        return postRepo.findPostByAuthor(author);
    }
}
