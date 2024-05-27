package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
}
