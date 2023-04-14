package miu.edu.lab5.springsecurity.repository;

import miu.edu.lab5.springsecurity.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepo extends JpaRepository<Logger, Long> {
}
