package pis.coursework.backend.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "status")
@Schema(name = "coursework")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Status {

    @Id
    @Column(name = "id_status")
    @GeneratedValue(generator = "status_seq")
    @SequenceGenerator(name = "status_seq", sequenceName = "STATUS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

}
