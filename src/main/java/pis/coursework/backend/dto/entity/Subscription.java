package pis.coursework.backend.dto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    @Id
    @Column(name = "id_sub")
    @GeneratedValue(generator = "sub_seq")
    @SequenceGenerator(name = "sub_seq", sequenceName = "SUB_SEQ", allocationSize = 1)
    private Long id;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

    @Column(name = "number_ticket")
    private String numberTicket;

    @Column(name = "date_sub")
    private LocalDateTime dateSub;

    @Column(name = "date_end")
    private LocalDateTime dateEnd;

}
