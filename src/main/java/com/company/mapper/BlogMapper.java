package com.company.mapper;

import com.company.domain.Blog;
import com.company.dto.BlogCreateDTO;
import org.springframework.stereotype.Component;

@org.mapstruct.Mapper(componentModel = "spring")
@Component
public interface BlogMapper {
    Blog fromCreateDTO(BlogCreateDTO dto);
}
