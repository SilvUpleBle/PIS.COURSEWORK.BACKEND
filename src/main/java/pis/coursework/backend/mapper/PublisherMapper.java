package pis.coursework.backend.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pis.coursework.backend.dto.PublisherDto;
import pis.coursework.backend.entity.Publisher;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.FIELD)
public interface PublisherMapper {

    PublisherDto toDto(Publisher publisher);

    Publisher toEntity(PublisherDto publisherDto);

    List<PublisherDto> listToDto(List<Publisher> publishers);

}
