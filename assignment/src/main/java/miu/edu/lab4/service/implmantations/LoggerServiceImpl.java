package miu.edu.lab4.service.implmantations;

import miu.edu.lab4.domain.Logger;
import miu.edu.lab4.repository.LoggerRepo;
import miu.edu.lab4.service.LoggerService;
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
