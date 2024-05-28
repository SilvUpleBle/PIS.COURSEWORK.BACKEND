package pis.coursework.backend.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Schema(name = "coursework")
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

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_author", referencedColumnName = "id_author")
    private Author author;

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
