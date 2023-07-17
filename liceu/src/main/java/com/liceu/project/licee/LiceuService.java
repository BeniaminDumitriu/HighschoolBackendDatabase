package com.liceu.project.licee;

import com.liceu.project.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiceuService {
    private final LiceuDao liceuDao;

    public LiceuService(LiceuDao liceuDao) {
        this.liceuDao = liceuDao;
    }

    public List<Liceu> getLicei() {
        return liceuDao.selectLicee();
    }

    public int addNewLiceu(Liceu liceu) {
        int result = liceuDao.insertLiceu(liceu);
        if (result != 1) {
            throw new IllegalStateException("Oops something went wrong");
        }
        return result;
    }

    public void deleteLiceu(Integer id) {
        Optional<Liceu> licei = liceuDao.selectLiceuById(id);
        licei.ifPresentOrElse(licee -> {
            int result = liceuDao.deleteLiceu(id);
            if (result != 1) {
                throw new IllegalStateException("Oops could not delete liceu");
            }
        }, () -> {
            throw new NotFoundException(String.format("Liceu with id %s not found", id));
        });
    }

    public Liceu getLiceu(int id) {
        return liceuDao.selectLiceuById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Liceu with id %s not found", id)));
    }
}
