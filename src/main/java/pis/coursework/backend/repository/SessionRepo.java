package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.entity.Session;

@Repository
public interface SessionRepo extends JpaRepository<Session,Long> {

    @Query(value = "SELECT * FROM coursework.sessions WHERE token = ?1 AND expirytime > NOW()", nativeQuery = true)
    Session findNonExpiredSessionByToken(String token);

    @Query(value = "SELECT * FROM coursework.sessions WHERE id_user = ?1 AND expirytime > NOW()", nativeQuery = true)
    Session findNonExpiredSessionByOperatorId(Long userId);

}
