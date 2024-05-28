package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.entity.Publisher;

import java.util.ArrayList;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Long> {

    Publisher getPublisherById(Long publisherId);

    @Query(value = "SELECT * FROM publisher", nativeQuery = true)
    ArrayList<Publisher> getAllPublishers();
    
}
