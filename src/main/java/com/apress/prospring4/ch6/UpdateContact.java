package com.apress.prospring4.ch6;

import org.springframework.jdbc.object.SqlUpdate;

public class UpdateContact extends SqlUpdate {
    private static final String SQL_UPDATE_CONTACT = "update CONTACT set first_name=:first_name, last_name=:last_name, birth_date=:birth_date where id=:id;";
}
