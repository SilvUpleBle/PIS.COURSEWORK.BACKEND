package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.entity.Status;

@Repository
public interface StatusRepo extends JpaRepository<Status, Long> {
}
