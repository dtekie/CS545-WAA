package miu.edu.lab3.Repo;

import miu.edu.lab3.Domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    @Query("select p from User p where count(p.posts)>=:n")
    public List<User> findUserByPostsGreaterThan(int n);

    @Query("select distinct p from Post p where p.title =: title")
    public User getTitle(String title);

}
