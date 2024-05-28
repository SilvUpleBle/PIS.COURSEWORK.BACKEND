package pis.coursework.backend.service;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pis.coursework.backend.dto.AuthorDto;
import pis.coursework.backend.entity.Author;
import pis.coursework.backend.mapper.AuthorMapper;
import pis.coursework.backend.repository.AuthorRepo;

import java.util.ArrayList;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepo authorRepo;
    private final AuthorMapper authorMapper;

    @Transactional(readOnly = true)
    public AuthorDto getAuthorById(Long authorId) {
        return authorMapper.toDto(authorRepo.findById(authorId).orElseThrow(() ->
                new EntityExistsException("Автора по такому id не существует")));
    }

    @Transactional(readOnly = true)
    public ArrayList<AuthorDto> getAllAuthors() {
        return authorMapper.listToDto(authorRepo.getAllAuthors());
    }

    @Transactional
    public void createAuthor(AuthorDto authorDto) {
        authorRepo.save(Author.builder()
                .firstname(authorDto.getFirstname())
                .surname(authorDto.getSurname())
                .middlename(authorDto.getSurname())
                .country(authorDto.getCountry())
                .datebirth(authorDto.getDatebirth())
                .datedie(authorDto.getDatedie())
                .build());
    }

    @Transactional
    public void deleteAuthor(Long authorId) {
        if (authorRepo.getAuthorById(authorId) == null) {
            throw new EntityExistsException("Автора по такому id не существует");
        }
        authorRepo.deleteById(authorId);
    }

    @Transactional
    public void updateAuthor(Long authorId, AuthorDto authorDto) {
        if (authorRepo.getAuthorById(authorId) == null) {
            throw new EntityExistsException("Автора по такому id не существует");
        }
        Author updatedAuthor = authorMapper.toEntity(authorDto);
        updatedAuthor.setId(authorId);
        authorRepo.save(updatedAuthor);
    }


}
