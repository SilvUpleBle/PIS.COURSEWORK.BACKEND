package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pis.coursework.backend.entity.Check;

import java.util.ArrayList;

public interface CheckRepo extends JpaRepository<Check, Long> {

    Check getCheckById(Long checkId);

    @Query(value = "SELECT * FROM check_list", nativeQuery = true)
    ArrayList<Check> getAllChecks();
    
}
