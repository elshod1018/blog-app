package com.company.dao;

import com.company.domain.User;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDAO extends BaseDAO<User, String> {
    public UserDAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public User save(User user) {
        String insert = "insert into users(first_name, last_name, username, password) values(?,?,?,?) returning id;";
        return jdbcTemplate.queryForObject(
                insert,
                mapper(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getPassword());
    }

    @Override
    public User get(String id) {
        return jdbcTemplate.queryForObject("select u.* from users u where u.is_deleted = 0 and  u.id = ?;", mapper(), id);
    }

    @Override
    protected User delete(String s) {

        return null;
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("select u.* from users u where u.is_deleted = 0 ;", mapper());
    }

    @Override
    public User upate(User domain) {
        return null;
    }
}
