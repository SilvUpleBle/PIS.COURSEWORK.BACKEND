package pis.coursework.backend.contoroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pis.coursework.backend.dto.CheckDto;

@RestController("api/v1/check")
@RequestMapping("api/v1")
@Tag(name = "API записи о взятии книг", description = "Rest endpoints записей о взятии книг")
@Slf4j
public class CheckController {

    @PostMapping("/check")
    @Operation(summary = "Создание записи о взятии книги по переданному json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Запись о взятии книги успешно создана.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> addCheck(@RequestBody CheckDto checkDto) {
        return ResponseEntity.ok("Запись о взятии книги успешно создана!");
    }

    @GetMapping("/check")
    @Operation(summary = "Получение информации о всех взятиях книг")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об взятиях книг.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> getAllChecks() {
        return ResponseEntity.ok("Информация об взятиях книг!");
    }

    @GetMapping("/check/{checkId}")
    @Operation(summary = "Получение информации о записи о взятии книги по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация о записи о взятии книги.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> getCheckById(@PathVariable Long checkId) {
        return ResponseEntity.ok("Информация о записи о взятии книги!");
    }

    @DeleteMapping("/check/{checkId}")
    @Operation(summary = "Удаление записи о взятии книги по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Запись о взятии книги успешно удалёна.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> deleteCheckById(@PathVariable Long checkId) {
        return ResponseEntity.ok("Запись о взятии книги успешно удалёна!");
    }

    @PutMapping("/check/{checkId}")
    @Operation(summary = "Редактирование записи о взятии книги по переданному id и json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация о ??? успешно обновлена.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> updateCheckById(@PathVariable Long checkId, @RequestBody CheckDto changeCheck) {
        return ResponseEntity.ok("Информация о ??? успешно обновлена!");
    }
    
}
