package pis.coursework.backend.service;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pis.coursework.backend.dto.BookDto;
import pis.coursework.backend.entity.Book;
import pis.coursework.backend.mapper.BookMapper;
import pis.coursework.backend.repository.BookRepo;
import pis.coursework.backend.repository.PublisherRepo;

import java.util.ArrayList;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepo bookRepo;
    private final BookMapper bookMapper;
    private final PublisherRepo publisherRepo;

    @Transactional(readOnly = true)
    public BookDto getBookById(Long bookId) {
        return bookMapper.toDto(bookRepo.findById(bookId).orElseThrow(() ->
                new EntityExistsException("Книги по такому id не существует")));
    }

    @Transactional(readOnly = true)
    public ArrayList<BookDto> getAllBooks() {
        return bookMapper.listToDto(bookRepo.getAllBooks());
    }

    @Transactional
    public void createBook(BookDto bookDto) {
        bookRepo.save(Book.builder()
                .cost(bookDto.getCost())
                .name(bookDto.getName())
                .dateEntrance(bookDto.getDateEntrance())
                .datePublishing(bookDto.getDatePublishing())
                .publisher(publisherRepo.getPublisherById(bookDto.getPublisherId()))
                .authorId(bookDto.getAuthorId())
                .build());
    }

    @Transactional
    public void deleteBook(Long bookId) {
        if (bookRepo.getBookById(bookId) == null) {
            throw new EntityExistsException("Книги по такому id не существует");
        }
        bookRepo.deleteById(bookId);
    }

    @Transactional
    public void updateBook(Long bookId, BookDto bookDto) {
        if (bookRepo.getBookById(bookId) == null) {
            throw new EntityExistsException("Книги по такому id не существует");
        }
        Book updatedBook = bookMapper.toEntity(bookDto);
        updatedBook.setId(bookId);
        bookRepo.save(updatedBook);
    }

}
