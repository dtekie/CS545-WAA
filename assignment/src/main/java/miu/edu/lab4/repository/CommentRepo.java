package miu.edu.lab4.repository;

import miu.edu.lab4.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    @Transactional
    @Modifying
    @Query("update Comment c set c.id = ?1")
    void updateIdBy(long id);
}
