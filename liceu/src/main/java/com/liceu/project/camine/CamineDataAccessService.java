package com.liceu.project.camine;

import com.liceu.project.elevi.ElevRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class CamineDataAccessService implements CamineDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Camin> selectCamine() {
        String sql = "SELECT * FROM Camine";
        return jdbcTemplate.query(sql, new CaminRowMapper());
    }

    @Override
    public int insertCamin(Camin camin) {
        String sql = "INSERT INTO Camine (numar, adresa, numar_total_camere) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, camin.getNumar(), camin.getAdresa(), camin.getNumarTotalCamere());
    }

    @Override
    public int deleteCamin(int id) {
        String sql = "DELETE FROM Camine WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Camin> selectCaminById(int id) {
        var sql = """
                SELECT
                id,
                numar,
                adresa,
                numar_total_camere,
                liceu_id
                FROM elevi
                WHERE id = ?
                """;
        return jdbcTemplate.query(sql, new CaminRowMapper(), id)
                .stream()
                .findFirst();
    }
}
