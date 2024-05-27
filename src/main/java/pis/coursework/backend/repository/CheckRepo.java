package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pis.coursework.backend.entity.Check;

public interface CheckRepo extends JpaRepository<Check, Long> {
}
