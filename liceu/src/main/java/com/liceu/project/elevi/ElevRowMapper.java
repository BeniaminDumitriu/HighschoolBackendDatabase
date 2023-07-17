package com.liceu.project.elevi;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ElevRowMapper implements RowMapper<Elev> {
    @Override
    public Elev mapRow(ResultSet rs, int rowNum) throws SQLException {
        Elev elev = new Elev();
        elev.setId(rs.getInt("id"));
        elev.setNume(rs.getString("nume"));
        elev.setPrenume(rs.getString("prenume"));
        elev.setTelefon(rs.getString("telefon"));

        return elev;
    }
}

