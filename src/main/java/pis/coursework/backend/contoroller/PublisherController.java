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
import pis.coursework.backend.dto.PublisherDto;
import pis.coursework.backend.service.PublisherService;

@RestController("api/v1/publisher")
@RequestMapping("api/v1")
@Tag(name = "API издатели", description = "Rest endpoints издателей")
@Slf4j
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    @PostMapping("/publisher")
    @Operation(summary = "Создание издателя по переданному json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Издатель успешно создан.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> addPublisher(@RequestBody PublisherDto publisherDto) {
        try {
            publisherService.createPublisher(publisherDto);
            return ResponseEntity.ok("Издатель успешно создан.");
        } catch (DataIntegrityViolationException e) {
            log.error("Возникла ошибка во время создания издателя.", e);
            return ResponseEntity.status(400).body("Возникла ошибка во время создания издателя.\n" + e.getMessage());
        } catch (Exception e) {
            log.error("Возникла ошибка во время создания издателя.", e);
            return ResponseEntity.status(500).body(e.getClass().toString());
        }
    }

    @GetMapping("/publisher")
    @Operation(summary = "Получение информации о всех издательствах")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об издательствах.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<Object> getAllAuthors() {
        return ResponseEntity.ok(publisherService.getAllPublishers());
    }

    @GetMapping("/publisher/{publisherId}")
    @Operation(summary = "Получение информации об издателе по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об издателе.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<Object> getPublisherById(@PathVariable Long publisherId) {
        try {
            return ResponseEntity.ok(publisherService.getPublisherById(publisherId));
        } catch (Exception e) {
            log.error("Возникла ошибка во время получения информации об издателе.", e);
            if (e.getClass().equals(EntityExistsException.class)) {
                return ResponseEntity.status(404).body(e.getMessage());
            }
            return ResponseEntity.status(500).body("Возникла ошибка во время получения информации об издателе.");
        }
    }

    @DeleteMapping("/publisher/{publisherId}")
    @Operation(summary = "Удаление издателя по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Издатель успешно удалён.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> deletePublisherById(@PathVariable Long publisherId) {
        try {
            publisherService.deletePublisher(publisherId);
            return ResponseEntity.ok("Издатель успешно удалён!");
        } catch (Exception e) {
            log.error("Возникла ошибка во время удаления издателя.", e);
            if (e.getClass().equals(EntityExistsException.class)) {
                return ResponseEntity.status(404).body(e.getMessage());
            }
            return ResponseEntity.status(500).body("Возникла ошибка во время удаления издателя.");
        }
    }

    @PutMapping("/publisher/{publisherId}")
    @Operation(summary = "Редактирование издателя по переданному id и json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об издателе успешно обновлена.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> updatePublisherById(@PathVariable Long publisherId, @RequestBody PublisherDto changePublisher) {
        try {
            publisherService.updatePublisher(publisherId, changePublisher);
            return ResponseEntity.ok("Информация об издателе успешно обновлена!");
        } catch (Exception e) {
            log.error("Возникла ошибка во время обновления информации об издателе.", e);
            if (e.getClass().equals(EntityExistsException.class)) {
                return ResponseEntity.status(404).body("Издателя с таким id не существует.");
            }
            return ResponseEntity.status(500).body("Возникла ошибка во время обновления информации об издателе.\n" + e.getMessage());
        }
    }
    
}
