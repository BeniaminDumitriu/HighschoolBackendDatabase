package com.liceu.project.licee;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LiceeDataAccessService implements LiceuDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Liceu> selectLicee() {
        String sql = "SELECT * FROM Licee";
        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            return Liceu.builder()
                    .id(resultSet.getInt("id"))
                    .nume(resultSet.getString("nume"))
                    .adresa(resultSet.getString("adresa"))
                    .isDeleted(resultSet.getInt("is_deleted"))
                    .build();
        });
    }

    @Override
    public int insertLiceu(Liceu liceu) {
        String sql = "INSERT INTO Licee (nume, adresa) VALUES (?, ?)";
        return jdbcTemplate.update(sql, liceu.getNume(), liceu.getAdresa());
    }

    @Override
    public int deleteLiceu(int id) {
        String sql = "DELETE FROM Licee WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Liceu> selectLiceuById(int id) {
        var sql = """
                SELECT
                id,
                nume,
                adresa,
                is_deleted
                FROM licee
                WHERE id = ?
                """;
        return jdbcTemplate.query(sql, new LiceuRowMapper(), id)
                .stream()
                .findFirst();
    }
}
