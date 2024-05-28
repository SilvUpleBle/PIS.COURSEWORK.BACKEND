package pis.coursework.backend.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pis.coursework.backend.dto.UserDto;
import pis.coursework.backend.entity.User;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.FIELD)
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    ArrayList<UserDto> listToDto(List<User> users);

}
