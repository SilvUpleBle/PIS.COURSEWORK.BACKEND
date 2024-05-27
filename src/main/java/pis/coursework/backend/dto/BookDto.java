package pis.coursework.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import pis.coursework.backend.entity.Author;
import pis.coursework.backend.entity.Publisher;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private Long authorId;

    @NotNull
    private LocalDateTime datePublishing;

    @NotNull
    private LocalDateTime dateEntrance;

    @NotNull
    private Integer cost;

    @NotNull
    private Long publisherId;

}
