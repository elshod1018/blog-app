/*
package com.company.dao;

import com.company.domain.Blog;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BlogDAO extends BaseDAO<Blog, String> {
    public BlogDAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public Blog save(Blog blog) {
        String insertQuery = "insert into blogs (owner_id, title, overview, content) values ( ?, ?, ?, ?) returning id;";
        return jdbcTemplate.queryForObject(
                insertQuery,
                mapper(),
                blog.getOwnerId(),
                blog.getTitle(),
                blog.getOverview(),
                blog.getContent());
    }

    @Override
    public Blog get(String id) {
        String getQuery = "select b.* from blogs b where b.is_deleted = 0 and  b.id = ?;";
        return jdbcTemplate.queryForObject(
                getQuery,
                mapper(),
                id);
    }

    @Override
    public Blog delete(String s) {
        return null;
    }

    @Override
    public List<Blog> getAll() {
        String getAllQuery = "select b.* from blogs b where b.is_deleted = 0 ;";
        return jdbcTemplate.query(getAllQuery, mapper());
    }

    @Override
    public Blog upate(Blog domain) {
        return null;
    }
}
*/
