package miu.edu.lab5.springsecurity.repository;

import miu.edu.lab5.springsecurity.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    User findByUsername(String username);

}
