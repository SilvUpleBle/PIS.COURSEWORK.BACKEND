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
import pis.coursework.backend.dto.UserDto;
import pis.coursework.backend.service.UserService;

@RestController("api/v1/user")
@RequestMapping("api/v1")
@Tag(name = "API пользователи", description = "Rest endpoints пользователей")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    @Operation(summary = "Создание пользователя по переданному json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Пользователь успешно создан.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
        try {
            userService.createUser(userDto);
            return ResponseEntity.ok("Пользователь успешно создан.");
        } catch (DataIntegrityViolationException e) {
            log.error("Возникла ошибка во время создания пользователя.", e);
            return ResponseEntity.status(400).body("Возникла ошибка во время создания пользователя.\n" + e.getMessage());
        } catch (Exception e) {
            log.error("Возникла ошибка во время создания пользователя.", e);
            return ResponseEntity.status(500).body(e.getClass().toString());
        }
    }

    @GetMapping("/user")
    @Operation(summary = "Получение информации о всех пользователях")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация о пользователях.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Получение информации о пользователе по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация о пользователе.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<Object> getUserById(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(userService.getUserById(userId));
        } catch (Exception e) {
            log.error("Возникла ошибка во время получения информации о пользователе.", e);
            if (e.getClass().equals(EntityExistsException.class)) {
                return ResponseEntity.status(404).body(e.getMessage());
            }
            return ResponseEntity.status(500).body("Возникла ошибка во время получения информации о пользователе.");
        }
    }

    @DeleteMapping("/user/{userId}")
    @Operation(summary = "Удаление пользователя по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Пользователь успешно удалён.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok("Пользователь успешно удалён!");
        } catch (Exception e) {
            log.error("Возникла ошибка во время удаления пользователя.", e);
            if (e.getClass().equals(EntityExistsException.class)) {
                return ResponseEntity.status(404).body(e.getMessage());
            }
            return ResponseEntity.status(500).body("Возникла ошибка во время удаления пользователя.");
        }
    }

    @PutMapping("/user/{userId}")
    @Operation(summary = "Редактирование пользователя по переданному id и json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация о пользователе успешно обновлена.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> updateUserById(@PathVariable Long userId, @RequestBody UserDto changeUser) {
        return ResponseEntity.ok("Информация о пользователе успешно обновлена!");
    }
    
}
