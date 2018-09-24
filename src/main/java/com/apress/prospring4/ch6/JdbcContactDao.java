package com.apress.prospring4.ch6;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcContactDao implements ContactDao, InitializingBean {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public String findFirstNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "select first_name from SPRING_4_BOOK.CONTACT where id = ?",
                new Object[]{id}, String.class);
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        MySQLErrorCodesTranslator errorTranslator = new MySQLErrorCodesTranslator();

        errorTranslator.setDataSource(dataSource);
        jdbcTemplate.setExceptionTranslator(errorTranslator);
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null){
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }
        if (jdbcTemplate == null){
            throw new BeanCreationException("Null JdbcTemplate on ContactDao");
        }
    }

    @Override
    public List<Contact> findAll() {
        return null;
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findLastNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Contact contact) {

    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void delete(Long contactId) {

    }
}
