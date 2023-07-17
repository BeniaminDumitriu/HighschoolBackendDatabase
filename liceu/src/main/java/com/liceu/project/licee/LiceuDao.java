package com.liceu.project.licee;

import java.util.List;
import java.util.Optional;

public interface LiceuDao {
    List<Liceu> selectLicee();
    int insertLiceu(Liceu liceu);
    int deleteLiceu(int id);
    Optional<Liceu> selectLiceuById(int id);
}
