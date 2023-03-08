package com.company.controller;

import com.company.dao.BlogDAO;
import com.company.dao.UserDAO;
import com.company.domain.Blog;
import com.company.domain.User;
import com.company.dto.BlogCreateDTO;
import com.company.dto.UserCreateDTO;
import com.company.mapper.BlogMapper;
import com.company.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
    private final UserDAO userDAO;
    private final BlogDAO blogDAO;
    private final UserMapper userMapper;

    private final BlogMapper blogMapper;

    public BlogController(UserDAO userDAO, BlogDAO blogDAO, UserMapper userMapper, BlogMapper blogMapper) {
        this.userDAO = userDAO;
        this.blogDAO = blogDAO;
        this.userMapper = userMapper;
        this.blogMapper = blogMapper;
    }

    @GetMapping("/create")
    public String createPage() {
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute BlogCreateDTO dto) {
        Blog blog = blogMapper.fromCreateDTO(dto);
        blogDAO.save(blog);
        return "redirect:/home";
    }
}
