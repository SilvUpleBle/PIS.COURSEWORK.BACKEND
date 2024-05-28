package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.entity.Author;

import java.util.ArrayList;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

    Author getAuthorById(Long authorId);

    @Query(value = "SELECT * FROM authors", nativeQuery = true)
    ArrayList<Author> getAllAuthors();

    @Query(value = "SELECT * FROM authors WHERE id_author in ?1", nativeQuery = true)
    ArrayList<Author> getAllAuthorsByIds(ArrayList<Long> ids);

}
