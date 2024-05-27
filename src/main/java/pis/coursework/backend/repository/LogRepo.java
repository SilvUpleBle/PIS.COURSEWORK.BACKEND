package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.entity.Log;

@Repository
public interface LogRepo extends JpaRepository<Log, Long> {
}
