package miu.edu.lab3.Repo;

import miu.edu.lab3.Domain.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo  extends CrudRepository<Post, Long> {

    @Query("select p from Post p where p.title =: title")
    Post getTitle(String title);
}
