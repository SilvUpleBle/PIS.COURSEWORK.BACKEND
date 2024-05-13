package pis.coursework.backend.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pis.coursework.backend.dto.entity.Check;

public interface CheckRepo extends JpaRepository<Check, Long> {
}
