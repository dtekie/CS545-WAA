package miu.edu.lab5.springsecurity.repository;

import miu.edu.lab5.springsecurity.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Long> {
    Role findByRolename(String rolename);
}
