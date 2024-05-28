package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.entity.Status;

import java.util.ArrayList;

@Repository
public interface StatusRepo extends JpaRepository<Status, Long> {

    Status getStatusById(Long statusId);

    @Query(value = "SELECT * FROM status", nativeQuery = true)
    ArrayList<Status> getAllStatuses();
    
}
