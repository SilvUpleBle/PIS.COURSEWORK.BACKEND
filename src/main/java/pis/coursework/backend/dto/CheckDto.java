package pis.coursework.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    private Long bookId;

    @NotNull
    private Integer statusId;

    @NotNull
    private Long subscriptionId;

    @NotNull
    private LocalDateTime dateAdd;

    @NotNull
    private Integer datePass;

    @NotNull
    private LocalDateTime deadline;

    @NotNull
    private String comment;

}
