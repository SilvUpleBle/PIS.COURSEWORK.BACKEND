package pis.coursework.backend.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name = "books")
@Schema(name = "coursework")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @Column(name = "id_book")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "id_author")
    @ElementCollection
    private ArrayList<Long> authorId;

    @Column(name = "date_publishing")
    private LocalDateTime datePublishing;

    @Column(name = "date_entrance")
    private LocalDateTime dateEntrance;

    @Column(name = "date_cancellation")
    private LocalDateTime dateCancellation;

    @Column(name = "cost")
    private Integer cost;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_publisher", referencedColumnName = "id_publisher")
    private Publisher publisher;

}
