package pis.coursework.backend.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pis.coursework.backend.dto.BookDto;
import pis.coursework.backend.entity.Book;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.FIELD)
public interface BookMapper {

    BookDto toDto(Book book);

    Book toEntity(BookDto bookDto);

    List<BookDto> listToDto(List<Book> books);

}
