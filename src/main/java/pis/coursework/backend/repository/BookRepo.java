package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.entity.Book;

import java.util.ArrayList;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    Book getBookById(Long bookId);

    @Query(value = "SELECT * FROM books", nativeQuery = true)
    ArrayList<Book> getAllBooks();
    
}
