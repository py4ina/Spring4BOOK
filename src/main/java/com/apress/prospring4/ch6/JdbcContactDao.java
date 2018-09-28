package com.apress.prospring4.ch6;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("contactDao")
public class JdbcContactDao implements ContactDao, InitializingBean {
    private Log log = LogFactory.getLog(JdbcContactDao.class);

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource(){
        return dataSource;
    }

    @Override
    public String findLastNameById(Long id) {
        String sql = "select last_name from CONTACT where id = :contactId";

        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("contactId", id);

        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }

    @Override
    public List<Contact> findAllWithDetail() {
        String sql = "select c.id, c.first_name, c.last_name, c.birth_date, t.id AS contact_tel_id, t.tel_number, t.tel_type from CONTACT as c join CONTACT_TEL_DETAIL as t on c.id = t.contact_id";
        return namedParameterJdbcTemplate.query(sql, new ContactWithDetailExtractor());
    }

    @Override
    public List<Contact> findAll() {
        String sql = "select * from CONTACT";
        return namedParameterJdbcTemplate.query(sql, new ContactMapper());
    }

    @Override
    public String findFirstNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "select first_name from SPRING_4_BOOK.CONTACT where id = ?",
                new Object[]{id}, String.class);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null){
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }
        if (namedParameterJdbcTemplate == null){
            throw new BeanCreationException("Null namedParameterJdbcTemplate on ContactDao");
        }
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
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

    private static final class ContactMapper implements RowMapper<Contact> {
        @Override
        public Contact mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Contact contact = new Contact();
            contact.setId(resultSet.getLong("id"));
            contact.setFirstName(resultSet.getString("first_name"));
            contact.setLastName(resultSet.getString("last_name"));
            contact.setBirthDate(resultSet.getDate("birth_date"));
            return contact;
        }
    }

    private static final class ContactWithDetailExtractor implements ResultSetExtractor<List<Contact>> {
        @Override
        public List<Contact> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Long, Contact> map = new HashMap<>();
            Contact contact = null;

            while (rs.next()){
                Long id = rs. getLong ( "id");
                contact = map. get ( id) ;
                if (contact == null) {
                    contact = new Contact();
                    contact.setId(id);
                    contact.setFirstName(rs.getString("first_name"));
                    contact.setLastName(rs.getString("last_name"));
                    contact.setBirthDate(rs.getDate("birth_date"));
                    contact.setContactTelDetails(new ArrayList<>());
                    map.put(id, contact);
                }
                Long contactTelDetailId = rs. getLong ( "contact_tel_id");
                if (contactTelDetailId > 0) {
                    ContactTelDetail contactTelDetail = new ContactTelDetail();
                    contactTelDetail.setId(contactTelDetailId);
                    contactTelDetail.setContactId(id);
                    contactTelDetail.setTelType(rs.getString("tel_type"));
                    contactTelDetail.setTelNumber(rs.getString("tel_number"));
                    contact.getContactTelDetails().add(contactTelDetail);
                }
            }

            return new ArrayList<>(map.values());
        }
    }
}
