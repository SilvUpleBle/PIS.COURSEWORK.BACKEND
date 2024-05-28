package pis.coursework.backend.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pis.coursework.backend.dto.CheckDto;
import pis.coursework.backend.entity.Check;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.FIELD)
public interface CheckMapper {

    CheckDto toDto(Check check);

    Check toEntity(CheckDto checkDto);

    ArrayList<CheckDto> listToDto(List<Check> checkList);

}
