package com.company.controller;

import com.company.domain.Blog;
import com.company.dto.BlogCreateDTO;
import com.company.mapper.BlogMapper;
import com.company.mapper.UserMapper;
import com.company.repository.BlogRepository;
import com.company.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/blog")
public class BlogController {

    private final UserMapper userMapper;
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    private final BlogMapper blogMapper;


    @GetMapping("/create")
    public String createPage() {
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute BlogCreateDTO dto) {
        Blog blog = blogMapper.fromCreateDTO(dto);
        blogRepository.save(blog);
        return "redirect:/home";
    }
}
