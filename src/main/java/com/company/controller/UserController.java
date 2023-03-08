package com.company.controller;

import com.company.dao.BlogDAO;
import com.company.dao.UserDAO;
import com.company.domain.Blog;
import com.company.domain.User;
import com.company.dto.UserCreateDTO;
import com.company.mapper.UserMapper;
import com.company.repository.UserRepository;
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

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserController(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
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
        user = userRepository.save(user);

        return "redirect:/user/create";
    }
}
