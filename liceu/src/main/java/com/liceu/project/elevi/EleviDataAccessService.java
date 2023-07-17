package com.liceu.project.elevi;

import com.liceu.project.licee.LiceuRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EleviDataAccessService implements EleviDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Elev> selectElevi() {
        String sql = "SELECT * FROM Elevi";
        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            return Elev.builder()
                    .id(resultSet.getInt("id"))
                    .nume(resultSet.getString("nume"))
                    .prenume(resultSet.getString("prenume"))
                    .telefon(resultSet.getString("telefon"))
                    .build();
        });
    }

    @Override
    public int insertElev(Elev elev) {
        String sql = "INSERT INTO Elevi (nume, prenume, telefon) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, elev.getNume(), elev.getPrenume(), elev.getTelefon());
    }

    @Override
    public int deleteElev(int id) {
        String sql = "DELETE FROM Elevi WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Elev> selectElevById(int id) {
        var sql = """
                SELECT
                id,
                nume,
                prenume,
                telefon,
                liceu_id
                FROM elevi
                WHERE id = ?
                """;
        return jdbcTemplate.query(sql, new ElevRowMapper(), id)
                .stream()
                .findFirst();
    }
}
