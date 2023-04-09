package miu.edu.lab4.service;

import miu.edu.lab4.domain.Logger;
import org.springframework.stereotype.Service;

@Service
public interface LoggerService {
    public void saveLogger(Logger logger);
}
