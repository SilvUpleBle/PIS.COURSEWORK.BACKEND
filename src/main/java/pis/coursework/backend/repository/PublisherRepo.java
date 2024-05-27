package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.entity.Publisher;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Long> {
}
