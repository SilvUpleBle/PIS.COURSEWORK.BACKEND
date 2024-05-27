package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.entity.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
}
