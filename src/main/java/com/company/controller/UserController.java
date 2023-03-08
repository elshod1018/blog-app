package com.company.controller;

import com.company.dao.BlogDAO;
import com.company.dao.UserDAO;
import com.company.domain.Blog;
import com.company.domain.User;
import com.company.dto.UserCreateDTO;
import com.company.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserDAO userDAO;
    private final BlogDAO blogDAO;
    private final UserMapper userMapper;

    public UserController(UserDAO userDAO, BlogDAO blogDAO, UserMapper userMapper) {
        this.userDAO = userDAO;
        this.blogDAO = blogDAO;
        this.userMapper = userMapper;
    }
    @GetMapping
    public String list(Model model) {
        List<Blog> blogs = blogDAO.getAll();
        model.addAttribute("blogs", blogs);
        return "main";
    }

    @GetMapping("/create")
    public String createPage() {
        return "redirect:/user/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute UserCreateDTO dto) {
        User user = userMapper.fromCreateDTO(dto);
        user = userDAO.save(user);
        System.out.println(user);
        return "redirect:/user/create";
    }
}
