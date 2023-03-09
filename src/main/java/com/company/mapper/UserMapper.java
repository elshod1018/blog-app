package com.company.mapper;

import com.company.domain.User;
import com.company.dto.UserCreateDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    User fromCreateDTO(UserCreateDTO dto);
}
