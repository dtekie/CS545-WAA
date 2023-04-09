package miu.edu.lab1.Repo.impl;


import miu.edu.lab1.Domain.Post;
import miu.edu.lab1.Repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {

    private static List<Post> postList;
    private static int postId=100;

    static{
        postList = new ArrayList<>();
        Post post1 = new Post(1l,"The Crazy Man Formula", "Psycology", "Fisseha G/egziabher");
		Post post2 = new Post(2l,"Woldeab Woldemariam", "Visionary", "Dawit Mesfin");
		Post post3 = new Post(3l,"Rozan Selen", "Romance", "Estifanos Ghebremichael");
        postList.add(post1);
        postList.add(post2);
        postList.add(post3);
    }
    @Override
    public List<Post> findAll() {
        return postList;
    }

    @Override
    public Post findById(long id) {
        return postList
                .stream()
                .filter(l->l.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post p) {
        p.setId(postId);
        postId++;
        postList.add(p);
    }

    @Override
    public void delete(long id) {
        var p= postList
                .stream()
                .filter(l->l.getId()==id)
                .findFirst()
                .get();
        postList.remove(p);
    }

    @Override
    public void update(long id, Post p) {
        Post toUpdate= findById(id);
        toUpdate.setAuthor(p.getAuthor());
        toUpdate.setContent(p.getContent());
        toUpdate.setTitle(p.getTitle());

    }

    @Override
    public List<Post> findPostByAuthor(String author) {
        return postList
                .stream()
                .filter(l->l.getAuthor()==author)
                .collect(Collectors.toList());
    }
}
