package pis.coursework.backend.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sessions")
@Schema(name = "coursework")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Session {
    @Id
    @GeneratedValue(generator="sessions_seq")
    @SequenceGenerator(name="sessions_seq",sequenceName="SESSIONS_SEQ", allocationSize=1)
    private Long id;

    @Column(name = "token")
    private String token;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "expirytime")
    private LocalDateTime expiryTime;
}
