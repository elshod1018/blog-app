package com.company.mapper;

import com.company.domain.Blog;
import com.company.dto.BlogCreateDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface BlogMapper {
    Blog fromCreateDTO(BlogCreateDTO dto);
}
