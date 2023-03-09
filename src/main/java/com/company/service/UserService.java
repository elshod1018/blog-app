package com.company.service;

import com.company.domain.User;
import com.company.dto.UserCreateDTO;
import com.company.mapper.UserMapper;
import com.company.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public User save(UserCreateDTO dto) {
        User user = userMapper.fromCreateDTO(dto);
        userRepository.save(user);
        return user;
    }
}
