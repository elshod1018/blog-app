package com.company.mapper;

import com.company.domain.User;
import com.company.dto.UserCreateDTO;
import org.springframework.stereotype.Component;

@org.mapstruct.Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    User fromCreateDTO(UserCreateDTO dto);
}
