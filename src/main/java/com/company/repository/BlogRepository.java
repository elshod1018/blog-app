package com.company.repository;

import com.company.domain.Blog;
import com.company.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog, String> {
    List<Blog> getAll();
}
