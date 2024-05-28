package pis.coursework.backend.contoroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pis.coursework.backend.dto.AuthorDto;
import pis.coursework.backend.service.AuthorService;

@RestController("api/v1/author")
@RequestMapping("api/v1")
@Tag(name = "API авторы", description = "Rest endpoints авторов")
@Slf4j
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/author")
    @Operation(summary = "Создание автора по переданному json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Автор успешно создан.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> addAuthor(@RequestBody AuthorDto authorDto) {
        try {
            authorService.createAuthor(authorDto);
            return ResponseEntity.ok("Автор успешно создан.");
        } catch (DataIntegrityViolationException e) {
            log.error("Возникла ошибка во время создания автора.", e);
            return ResponseEntity.status(400).body("Возникла ошибка во время создания автора.\n" + e.getMessage());
        } catch (Exception e) {
            log.error("Возникла ошибка во время создания автора.", e);
            return ResponseEntity.status(500).body(e.getClass().toString());
        }
    }

    @GetMapping("/author")
    @Operation(summary = "Получение информации о всех авторах")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об авторах.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<Object> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/author/{authorId}")
    @Operation(summary = "Получение информации об авторе по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об авторе.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<Object> getAuthorById(@PathVariable Long authorId) {
        try {
            return ResponseEntity.ok(authorService.getAuthorById(authorId));
        } catch (Exception e) {
            log.error("Возникла ошибка во время получения информации об авторе.", e);
            if (e.getClass().equals(EntityExistsException.class)) {
                return ResponseEntity.status(404).body(e.getMessage());
            }
            return ResponseEntity.status(500).body("Возникла ошибка во время получения информации об авторе.");
        }
    }

    @DeleteMapping("/author/{authorId}")
    @Operation(summary = "Удаление автора по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Автор успешно удалён.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> deleteAuthorById(@PathVariable Long authorId) {
        try {
            authorService.deleteAuthor(authorId);
            return ResponseEntity.ok("Автор успешно удалён!");
        } catch (Exception e) {
            log.error("Возникла ошибка во время удаления автора.", e);
            if (e.getClass().equals(EntityExistsException.class)) {
                return ResponseEntity.status(404).body(e.getMessage());
            }
            return ResponseEntity.status(500).body("Возникла ошибка во время удаления автора.");
        }
    }

    @PutMapping("/author/{authorId}")
    @Operation(summary = "Редактирование автора по переданному id и json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об авторе успешно обновлена.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> updateAuthorById(@PathVariable Long authorId, @RequestBody AuthorDto changeAuthor) {
        try {
            authorService.updateAuthor(authorId, changeAuthor);
            return ResponseEntity.ok("Информация об авторе успешно обновлена!!");
        } catch (Exception e) {
            log.error("Возникла ошибка во время обновления информации об авторе.", e);
            if (e.getClass().equals(EntityExistsException.class)) {
                return ResponseEntity.status(404).body("Автора с таким id не существует.");
            }
            return ResponseEntity.status(500).body("Возникла ошибка во время обновления информации об авторе.\n" + e.getMessage());
        }
    }
    
}
