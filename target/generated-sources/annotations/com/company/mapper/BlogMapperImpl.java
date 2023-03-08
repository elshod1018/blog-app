package com.company.mapper;

import com.company.domain.Blog;
import com.company.dto.BlogCreateDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-07T09:51:38+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Private Build)"
)
@Component
public class BlogMapperImpl implements BlogMapper {

    @Override
    public Blog fromCreateDTO(BlogCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Blog.BlogBuilder blog = Blog.builder();

        blog.ownerId( dto.ownerId() );
        blog.title( dto.title() );
        blog.overview( dto.overview() );
        blog.content( dto.content() );

        return blog.build();
    }
}
