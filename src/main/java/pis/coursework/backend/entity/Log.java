package pis.coursework.backend.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "log_list")
@Schema(name = "coursework")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Log {

    @Id
    @Column(name = "id_log")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "error")
    private String error;

    @Column(name = "time_add")
    private LocalDateTime timeAdd;

}
