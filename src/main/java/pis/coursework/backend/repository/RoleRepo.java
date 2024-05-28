package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.entity.Role;

import java.util.ArrayList;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    Role getRoleById(Long roleId);

    @Query(value = "SELECT * FROM role", nativeQuery = true)
    ArrayList<Role> getAllRoles();
    
}
