package miu.edu.lab2.Service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.lab2.Domain.Post;
import miu.edu.lab2.Repo.PostRepo;
import miu.edu.lab2.Service.PostService;
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
        return (List<Post>) postRepo.findAll();
    }

    @Override
    public Post findById(long id) {
        return postRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Post post) {
        postRepo.save(post);
    }

    @Override
    public void delete(long id) {
        postRepo.deleteById(id);

    }
    @Override
    public void update(long id, Post post) {
        Post p= postRepo.findById(id).orElse(null);
        p.setTitle(post.getTitle());
        p.setAuthor(post.getAuthor());
        p.setContent(post.getContent());
        postRepo.save(p);
    }
}
// below is another implementation of update method

//@Service
//@Transactional
//public class PostService {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public void update(long id, Post post) {
//        Post p = entityManager.find(Post.class, id);
//        if (p != null) {
//            p.setTitle(post.getTitle());
//            p.setAuthor(post.getAuthor());
//            p.setContent(post.getContent());
//            entityManager.merge(p);
//        }
//    }
//
//}
