package com.company.mapper;

import com.company.domain.Comment;
import com.company.dto.CommentCreateDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CommentMapper {
    Comment fromCreateDTO(CommentCreateDTO dto);
}
