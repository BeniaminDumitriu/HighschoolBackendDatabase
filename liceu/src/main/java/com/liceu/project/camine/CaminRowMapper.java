package com.liceu.project.camine;

import com.liceu.project.licee.Liceu;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CaminRowMapper implements RowMapper<Camin> {
    @Override
    public Camin mapRow(ResultSet rs, int rowNum) throws SQLException {
        Camin camin = new Camin();
        camin.setId(rs.getInt("id"));
        camin.setNumar(rs.getInt("numar"));
        camin.setAdresa(rs.getString("adresa"));
        camin.setNumarTotalCamere(rs.getInt("numar_total_camere"));

        Liceu liceu = new Liceu();
        liceu.setId(rs.getInt("liceu_id"));
        camin.setLiceu(liceu);

        return camin;
    }
}

