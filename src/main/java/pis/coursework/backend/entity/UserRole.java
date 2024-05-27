package pis.coursework.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {

    @Id
    @Column(name = "id_userrole")
    @GeneratedValue(generator = "userrole_seq")
    @SequenceGenerator(name = "userrole_seq", sequenceName = "USERROLE_SEQ", allocationSize = 1)
    private Long id;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_role", referencedColumnName = "id_role")
    private Role role;

}
