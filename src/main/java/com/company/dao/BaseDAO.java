/*
package com.company.dao;

import com.company.domain.Entity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseDAO<E extends Entity, ID extends Serializable> {
    protected final JdbcTemplate jdbcTemplate;
    protected final Class<E> persistenceClass;

    @SuppressWarnings("unchecked")
    protected BaseDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.persistenceClass = (Class<E>) (((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
    }

    protected abstract E save(E domain);
    protected abstract E get(ID id);
    protected abstract E delete(ID id);
    protected abstract List<E> getAll();
    protected abstract E upate(E domain);

    protected RowMapper<E> mapper() {
        return BeanPropertyRowMapper.newInstance(persistenceClass);
    }

}
*/
