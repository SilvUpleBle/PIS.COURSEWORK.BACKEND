package pis.coursework.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private ArrayList<Long> authorId;

    @NotNull
    private LocalDateTime datePublishing;

    @NotNull
    private LocalDateTime dateEntrance;

    @NotNull
    private Integer cost;

    @NotNull
    private Long publisherId;

}
