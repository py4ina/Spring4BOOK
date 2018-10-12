package com.apress.prospring4.ch6;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class InsertContactTelDetail extends BatchSqlUpdate {
    private static final String SQL_INSERT_CONTACT_CEL = "insert into CONTACT_TEL_DETAIL (contact_id, tel_type, tel_number) " +
            "VALUES (:contact_id, :tel_type, :tel_number)";

    private static final int BATCH_SIZE = 10;

    public InsertContactTelDetail(DataSource dataSource) {
        super(dataSource, SQL_INSERT_CONTACT_CEL);

        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("last_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("birth_date", Types.DATE));

        setBatchSize(BATCH_SIZE);
    }
}