package miu.edu.lab3.Repo;

import miu.edu.lab3.Domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {



}
