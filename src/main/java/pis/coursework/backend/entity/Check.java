package pis.coursework.backend.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "check_list")
@Schema(name = "coursework")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Check {

    @Id
    @Column(name = "id_check_list")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_book", referencedColumnName = "id_book")
    private Book book;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_status", referencedColumnName = "id_status")
    private Status status;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_sub", referencedColumnName = "id_sub")
    private Subscription subscription;

    @Column(name = "date_add")
    private LocalDateTime dateAdd;

    @Column(name = "date_pass")
    private Integer datePass;

    @Column(name = "deadline")
    private LocalDateTime deadline;

    @Column(name = "comment")
    private String comment;

}
