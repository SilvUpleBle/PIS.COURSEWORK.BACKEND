package pis.coursework.backend.contoroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pis.coursework.backend.dto.PublisherDto;

@RestController("api/v1/publisher")
@RequestMapping("api/v1")
@Tag(name = "API издатели", description = "Rest endpoints издателей")
@Slf4j
public class PublisherController {

    @PostMapping("/publisher")
    @Operation(summary = "Создание издателя по переданному json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Издатель успешно создан.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> addPublisher(@RequestBody PublisherDto publisherDto) {
        return ResponseEntity.ok("Издатель успешно создан!");
    }

    @GetMapping("/publisher")
    @Operation(summary = "Получение информации о всех издательствах")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об издательствах.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> getAllAuthors() {
        return ResponseEntity.ok("Информация об издательствах получена!");
    }

    @GetMapping("/publisher/{publisherId}")
    @Operation(summary = "Получение информации об издателе по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об издателе.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> getPublisherById(@PathVariable Long publisherId) {
        return ResponseEntity.ok("Информация об издателе получена!");
    }

    @DeleteMapping("/publisher/{publisherId}")
    @Operation(summary = "Удаление издателя по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Издатель успешно удалён.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> deletePublisherById(@PathVariable Long publisherId) {
        return ResponseEntity.ok("Издатель успешно удалён!");
    }

    @PutMapping("/publisher/{publisherId}")
    @Operation(summary = "Редактирование издателя по переданному id и json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об издателе успешно обновлена.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> updatePublisherById(@PathVariable Long publisherId, @RequestBody PublisherDto changePublisher) {
        return ResponseEntity.ok("Информация об издателе успешно обновлена!");
    }
    
}
