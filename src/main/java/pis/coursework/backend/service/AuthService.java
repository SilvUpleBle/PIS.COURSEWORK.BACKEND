package pis.coursework.backend.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pis.coursework.backend.entity.Session;
import pis.coursework.backend.entity.User;
import pis.coursework.backend.repository.SessionRepo;
import pis.coursework.backend.repository.UserRepo;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepo userRepo;
    private final SessionRepo sessionsRepo;

    public Session logIn(String login, String password) {
        Long userId = checkAuth(login, password);
        if (userId != null) {
            return createOrUpdateSession(userId);
        }
        return null;
    }

    public Session logOut(Long userId) {
        Session session = getNonExpiredSessionByOperatorId(userId);
        if (session != null) {
            session.setExpiryTime(LocalDateTime.now());
            sessionsRepo.save(session);
            return session;
        }
        return null;
    }

    public Session logOut(String token) {
        Session session = getNonExpiredSessionByToken(token);
        if (session != null) {
            session.setExpiryTime(LocalDateTime.now());
            sessionsRepo.save(session);
            return session;
        }
        return null;
    }

    public Long checkAuth(String login, String password) {
        User user = userRepo.getUserByLogin(login);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return user.getId();
            }
        }
        return null;
    }

    public boolean checkAuth(String token) {
        try {
            return getNonExpiredSessionByToken(token.split(" ")[1]) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkAuth(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            return getNonExpiredSessionByToken(token.split(" ")[1]) != null;
        } catch (Exception e) {
            log.error("{}  -  {}", e.getClass(), e.getMessage());
            return false;
        }
    }

    public Session getNonExpiredSessionByToken(String token) {
        return sessionsRepo.findNonExpiredSessionByToken(token);
    }

    public Session getNonExpiredSessionByOperatorId(Long userId) {
        return sessionsRepo.findNonExpiredSessionByOperatorId(userId);
    }

    private Session createOrUpdateSession(Long userId) {
        Session session = getNonExpiredSessionByOperatorId(userId);
        if (session != null) {
            session.setExpiryTime(LocalDateTime.now().plusMinutes(30));
            sessionsRepo.save(session);
            return session;
        }
        session = Session.builder()
                .user(userRepo.findById(userId).orElseThrow())
                .created(LocalDateTime.now())
                .expiryTime(LocalDateTime.now().plusMinutes(30))
                .token(UUID.randomUUID().toString().replaceAll("-", ""))
                .build();
        sessionsRepo.save(session);
        return session;
    }

}
