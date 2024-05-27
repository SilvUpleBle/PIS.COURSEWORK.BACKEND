package pis.coursework.backend.contoroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pis.coursework.backend.entity.Session;
import pis.coursework.backend.service.AuthService;

@RestController("api/v1/auth")
@RequestMapping("api/v1/auth")
@Tag(name = "API авторизации", description = "Rest endpoints авторизации")
@Slf4j
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/logIn")
    @Operation(summary = "Создание сессии по переданному логину и паролю")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Сессия успешно создана.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "404", description = "<p>Ошибка. Пользователь не найден.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<String> logIn(
            @RequestParam(value = "login") String login,
            @RequestParam(value = "password") String password
    ) {
        Session session = authService.logIn(login, password);
        if (session != null) {
            return ResponseEntity.ok(session.getToken());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/logOut")
    @Operation(summary = "Завершение сессии по переданному в хеддере токену")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "<p>OK. Сессия успешно завершена.</p>"),
            @ApiResponse(responseCode = "400", description = "<p>Ошибка. Приходит ответ с ошибкой.</p>"),
            @ApiResponse(responseCode = "500", description = "<p>Ошибка сервера. Приходит ответ с ошибкой.</p>")
    })
    public ResponseEntity<?> logOut(
            HttpServletRequest request
    ) {
        String token = request.getHeader("Authorization");
        if (!authService.checkAuth(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        Session session = authService.logOut(token.split(" ")[1]);
        if (session != null) {
            return ResponseEntity.ok(session);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
