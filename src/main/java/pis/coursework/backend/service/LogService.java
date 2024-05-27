package pis.coursework.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pis.coursework.backend.entity.Log;
import pis.coursework.backend.repository.LogRepo;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class LogService {
    private LogRepo logRepo;
    public void addLog(String error, Long userId){
        var log = new Log();
        log.setError(error);
        log.setTimeAdd(LocalDateTime.now());
        logRepo.save(log);
    }
}
