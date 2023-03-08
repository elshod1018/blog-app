package com.company.mapper;

import com.company.domain.User;
import com.company.dto.UserCreateDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-07T09:51:38+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Private Build)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User fromCreateDTO(UserCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstName( dto.firstName() );
        user.lastName( dto.lastName() );
        user.username( dto.username() );
        user.password( dto.password() );

        return user.build();
    }
}
