package com.company.repository;

import com.company.domain.Blog;
import com.company.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, String> {
    List<Blog> getAll();

    List<Blog> getAllByOwnerId(String ownerId);
}
