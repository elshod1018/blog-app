package com.company.controller;

import com.company.domain.Blog;
import com.company.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class MainController {
    private final BlogRepository blogRepository;

    @GetMapping({"/main", "/", "/home", ""})
    public String allBlogListPage(Model model) {
        List<Blog> blogs = blogRepository.getAll();
        model.addAttribute("blogs", blogs);
        return "main";
    }
}
