package pis.coursework.backend.contoroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pis.coursework.backend.dto.AuthorDto;

@RestController("api/v1/author")
@RequestMapping("api/v1")
@Tag(name = "API авторы", description = "Rest endpoints авторов")
@Slf4j
public class AuthorController {

    @PostMapping("/author")
    @Operation(summary = "Создание автора по переданному json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Автор успешно создан.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> addAuthor(@RequestBody AuthorDto authorDto) {
        return ResponseEntity.ok("Автор успешно создан!");
    }

    @GetMapping("/author")
    @Operation(summary = "Получение информации о всех авторах")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об авторах.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> getAllAuthors() {
        return ResponseEntity.ok("Информация об авторах получена!");
    }

    @GetMapping("/author/{authorId}")
    @Operation(summary = "Получение информации об авторе по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об авторе.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> getAuthorById(@PathVariable Long authorId) {
        return ResponseEntity.ok("Информация об авторе получена!");
    }

    @DeleteMapping("/author/{authorId}")
    @Operation(summary = "Удаление автора по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Автор успешно удалён.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> deleteAuthorById(@PathVariable Long authorId) {
        return ResponseEntity.ok("Автор успешно удалён!");
    }

    @PutMapping("/author/{authorId}")
    @Operation(summary = "Редактирование автора по переданному id и json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об авторе успешно обновлена.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> updateAuthorById(@PathVariable Long authorId, @RequestBody AuthorDto changeAuthor) {
        return ResponseEntity.ok("Информация об авторе успешно обновлена!");
    }
    
}
