package pis.coursework.backend.contoroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pis.coursework.backend.dto.UserDto;

@RestController("api/v1/user")
@RequestMapping("api/v1")
@Tag(name = "API пользователи", description = "Rest endpoints пользователей")
@Slf4j
public class UserController {

    @PostMapping("/user")
    @Operation(summary = "Создание пользователя по переданному json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Пользователь успешно создан.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok("Пользователь успешно создан!");
    }

    @GetMapping("/user")
    @Operation(summary = "Получение информации о всех пользователях")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация о пользователях.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok("Информация о пользователях получена!");
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Получение информации о пользователе по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Информация о пользователе.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok("Информация о пользователе получена!");
    }

    @DeleteMapping("/user/{userId}")
    @Operation(summary = "Удаление пользователя по переданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Пользователь успешно удалён.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId) {
        return ResponseEntity.ok("Пользователь успешно удалён!");
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
