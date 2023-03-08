package com.company.controller;

import com.company.dao.BlogDAO;
import com.company.dao.UserDAO;
import com.company.domain.Blog;
import com.company.domain.User;
import com.company.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping()
public class MainController {
    private final BlogDAO blogDAO;
    private final UserDAO userDAO;
    private final UserMapper userMapper;

    public MainController(BlogDAO blogDAO, UserDAO userDAO, UserMapper userMapper) {
        this.blogDAO = blogDAO;
        this.userDAO = userDAO;
        this.userMapper = userMapper;
    }

    @GetMapping({"/main", "/","home",""})
    public String list(Model model) {
        List<Blog> blogs = blogDAO.getAll();
        model.addAttribute("blogs", blogs);
        return "main";
    }
}
