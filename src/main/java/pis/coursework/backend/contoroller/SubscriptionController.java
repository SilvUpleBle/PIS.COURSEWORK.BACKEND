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
import pis.coursework.backend.dto.SubscriptionDto;
import pis.coursework.backend.service.SubscriptionService;

@RestController("api/v1/subscription")
@RequestMapping("api/v1")
@Tag(name = "API абонементы", description = "Rest endpoints абонементов")
@Slf4j
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping("/subscription")
    @Operation(summary = "Создание абонемента по переданному json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Абонемент успешно создан.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> addSubscription(@RequestBody SubscriptionDto subscriptionDto) {
        try {
            subscriptionService.createSubscription(subscriptionDto);
            return ResponseEntity.ok("Абонемент успешно создан.");
        } catch (DataIntegrityViolationException e) {
            log.error("Возникла ошибка во время создания абонемента.", e);
            return ResponseEntity.status(400).body("Возникла ошибка во время создания абонемента.\n" + e.getMessage());
        } catch (Exception e) {
            log.error("Возникла ошибка во время создания абонемента.", e);
            return ResponseEntity.status(500).body(e.getClass().toString());
        }
    }

    @GetMapping("/subscription")
    @Operation(summary = "Получение информации о всех абонементах")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об абонементах.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<Object> getAllSubscriptions() {
        return ResponseEntity.ok(subscriptionService.getAllSubscriptions());
    }

    @GetMapping("/subscription/{subscriptionId}")
    @Operation(summary = "Получение информации об абонементе по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об абонементе.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<Object> getSubscriptionById(@PathVariable Long subscriptionId) {
        try {
            return ResponseEntity.ok(subscriptionService.getSubscriptionById(subscriptionId));
        } catch (Exception e) {
            log.error("Возникла ошибка во время получения информации об абонементе.", e);
            if (e.getClass().equals(EntityExistsException.class)) {
                return ResponseEntity.status(404).body(e.getMessage());
            }
            return ResponseEntity.status(500).body("Возникла ошибка во время получения информации об абонементе.");
        }
    }

    @DeleteMapping("/subscription/{subscriptionId}")
    @Operation(summary = "Удаление абонемента по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Абонемент успешно удалён.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> deleteSubscriptionById(@PathVariable Long subscriptionId) {
        try {
            subscriptionService.deleteSubscription(subscriptionId);
            return ResponseEntity.ok("Абонемент успешно удалён!");
        } catch (Exception e) {
            log.error("Возникла ошибка во время удаления абонемента.", e);
            if (e.getClass().equals(EntityExistsException.class)) {
                return ResponseEntity.status(404).body(e.getMessage());
            }
            return ResponseEntity.status(500).body("Возникла ошибка во время удаления абонемента.");
        }
    }

    @PutMapping("/subscription/{subscriptionId}")
    @Operation(summary = "Редактирование абонемента по переданному id и json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация об абонементе успешно обновлена.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> updateSubscriptionById(@PathVariable Long subscriptionId, @RequestBody SubscriptionDto changeSubscription) {
        try {
            subscriptionService.updateSubscription(subscriptionId, changeSubscription);
            return ResponseEntity.ok("Информация об абонементе успешно обновлена!");
        } catch (Exception e) {
            log.error("Возникла ошибка во время обновления информации об абонементе.", e);
            if (e.getClass().equals(EntityExistsException.class)) {
                return ResponseEntity.status(404).body("Абонемента с таким id не существует.");
            }
            return ResponseEntity.status(500).body("Возникла ошибка во время обновления информации об абонементе.\n" + e.getMessage());
        }
    }

}
