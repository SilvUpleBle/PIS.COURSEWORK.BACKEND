package pis.coursework.backend.contoroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pis.coursework.backend.dto.BookDto;
import pis.coursework.backend.repository.BookRepo;

@RestController("api/v1/book")
@RequestMapping("api/v1")
@Tag(name = "API книги", description = "Rest endpoints книг")
@Slf4j
public class BookController {
    @Autowired
    BookRepo bookRepo;

    @PostMapping("/book")
    @Operation(summary = "Создание книги по переданному json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Книга успешно создана.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> addBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok("Книга успешно создана!");
    }

    @GetMapping("/book")
    @Operation(summary = "Получение информации о всех книгах")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об книгах.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> getAllBooks() {
        return ResponseEntity.ok("Информация о книгах получена!");
    }

    @GetMapping("/book/{bookId}")
    @Operation(summary = "Получение информации о книге по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация о книге.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> getBookById(@PathVariable Long bookId) {
        return ResponseEntity.ok("Информация о книге получена!");
    }

    @DeleteMapping("/book/{bookId}")
    @Operation(summary = "Удаление книги по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Книга успешно удалена.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> deleteBookById(@PathVariable Long bookId) {
        return ResponseEntity.ok("Книга успешно удалена!");
    }

    @PutMapping("/book/{bookId}")
    @Operation(summary = "Редактирование книги по переданному id и json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация о книге успешно обновлена.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> updateBookById(@PathVariable Long bookId, @RequestBody BookDto changeBook) {
        return ResponseEntity.ok("Информация о книге успешно обновлена!");
    }

}
