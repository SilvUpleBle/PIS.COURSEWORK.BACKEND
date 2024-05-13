package pis.coursework.backend.dto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @Column(name = "id_book")
    @GeneratedValue(generator = "books_seq")
    @SequenceGenerator(name = "books_seq", sequenceName = "BOOKS_SEQ", allocationSize = 1)
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
