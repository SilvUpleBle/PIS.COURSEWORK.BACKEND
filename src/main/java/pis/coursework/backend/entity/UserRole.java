package pis.coursework.backend.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_role")
@Schema(name = "coursework")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {

    @Id
    @Column(name = "id_userrole")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_role", referencedColumnName = "id_role")
    private Role role;

}
