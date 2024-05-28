package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.entity.Log;

import java.util.ArrayList;

@Repository
public interface LogRepo extends JpaRepository<Log, Long> {

    Log getLogById(Long logId);

    @Query(value = "SELECT * FROM log_list", nativeQuery = true)
    ArrayList<Log> getAllLogs();
    
}
