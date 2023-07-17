package com.liceu.project.licee;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LiceuRowMapper implements RowMapper<Liceu> {
    @Override
    public Liceu mapRow(ResultSet rs, int rowNum) throws SQLException {
        Liceu liceu = new Liceu();
        liceu.setId(rs.getInt("id"));
        liceu.setNume(rs.getString("nume"));
        liceu.setAdresa(rs.getString("adresa"));
        liceu.setIsDeleted(rs.getInt("is_deleted"));

        return liceu;
    }
}

