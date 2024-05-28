package pis.coursework.backend.service;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pis.coursework.backend.dto.UserDto;
import pis.coursework.backend.entity.User;
import pis.coursework.backend.mapper.UserMapper;
import pis.coursework.backend.repository.UserRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public UserDto getUserById(Long userId) {
        return userMapper.toDto(userRepo.findById(userId).orElseThrow(() ->
                new EntityExistsException("Пользователя по такому id не существует")));
    }

    @Transactional(readOnly = true)
    public ArrayList<UserDto> getAllUsers() {
        return userMapper.listToDto(userRepo.getAllUsers());
    }

    @Transactional
    public void createUser(UserDto userDto) {
        userRepo.save(User.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .surname(userDto.getSurname())
                .name(userDto.getName())
                .middlename(userDto.getMiddlename())
                .datebirth(userDto.getDatebirth())
                .dateReg(LocalDateTime.now())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .adress(userDto.getAdress())
                .phone(userDto.getPhone())
                .build());
    }

    @Transactional
    public void deleteUser(Long userId) {
        if (userRepo.getUserById(userId) == null) {
            throw new EntityExistsException("Пользователя по такому id не существует");
        }
        userRepo.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, UserDto userDto) {
        if (userRepo.getUserById(userId) == null) {
            throw new EntityExistsException("Пользователя по такому id не существует");
        }
        User oldUser = userRepo.getUserById(userId);
        User updatedUser = userMapper.toEntity(userDto);
        updatedUser.setId(userId);
        updatedUser.setDateReg(oldUser.getDateReg());
        userRepo.save(updatedUser);
    }

}
