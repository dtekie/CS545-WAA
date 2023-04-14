package miu.edu.lab5.springsecurity.service.impl;

import miu.edu.lab5.springsecurity.entity.Logger;
import miu.edu.lab5.springsecurity.repository.LoggerRepo;
import miu.edu.lab5.springsecurity.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService {
    @Autowired
    private LoggerRepo loggerRepo;
    @Override
    public void saveLogger(Logger logger) {
        loggerRepo.save(logger);
    }
}
