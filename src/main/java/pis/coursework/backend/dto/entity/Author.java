package pis.coursework.backend.dto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "authors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @Column(name = "id_author")
    @GeneratedValue(generator = "authors_seq")
    @SequenceGenerator(name = "authors_seq", sequenceName = "AUTHORS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String firstname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "datebirth")
    private LocalDateTime datebirth;

    @Column(name = "datedie")
    private LocalDateTime datedie;

    @Column(name = "country")
    private String country;

}
