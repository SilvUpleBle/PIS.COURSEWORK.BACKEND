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
public class UserDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    private String surname;

    @NotNull
    private String name;

    @NotNull
    private String middlename;

    @NotNull
    private LocalDateTime datebirth;

    @NotNull
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String address;

}
