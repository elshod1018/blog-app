package com.company.controller;

import com.company.domain.Blog;
import com.company.domain.User;
import com.company.dto.UserCreateDTO;
import com.company.mapper.UserMapper;
import com.company.repository.BlogRepository;
import com.company.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final BlogRepository blogRepository;
    private final UserMapper userMapper;


    @GetMapping
    public String list(Model model) {
        List<Blog> blogs = blogRepository.getAll();
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
        userRepository.save(user);
        return "redirect:/user/create";
    }
}
