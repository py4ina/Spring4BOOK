package com.apress.prospring4.ch6;

import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllContacts extends MappingSqlQuery<Contact> {
    private static final String SQL_SELECT_ALL_CONTACT = "select id, first_name, birth_date from CONTACT";

    public SelectAllContacts(DataSource dataSource) {
        super(dataSource, SQL_SELECT_ALL_CONTACT);
    }

    @Override
    protected Contact mapRow(ResultSet rs, int rowNumber) throws SQLException {
        Contact contact = new Contact();

        contact.setId(rs.getLong("id"));
        contact.setFirstName(rs.getString("first_name"));
        contact.setLastName(rs.getString("last_name"));
        contact.setBirthDate(rs.getDate("birth_date"));

        return contact;
    }
}
