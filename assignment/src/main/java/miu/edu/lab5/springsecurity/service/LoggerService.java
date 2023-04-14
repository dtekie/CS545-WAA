package miu.edu.lab5.springsecurity.service;

import miu.edu.lab5.springsecurity.entity.Logger;
import org.springframework.stereotype.Service;

@Service
public interface LoggerService {
    public void saveLogger(Logger logger);
}
