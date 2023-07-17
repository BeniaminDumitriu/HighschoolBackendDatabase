package com.liceu.project.camine;

import com.liceu.project.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaminService {
    private final CamineDao caminDao;

    public CaminService(CamineDao caminDao) {
        this.caminDao = caminDao;
    }

    public List<Camin> getCamine() {
        return caminDao.selectCamine();
    }

    public int addNewCamin(Camin camin) {
        int result = caminDao.insertCamin(camin);
        if (result != 1) {
            throw new IllegalStateException("Oops something went wrong");
        }
        return result;
    }

    public void deleteCamin(Integer id) {
        Optional<Camin> camin = caminDao.selectCaminById(id);
        camin.ifPresentOrElse(c -> {
            int result = caminDao.deleteCamin(id);
            if (result != 1) {
                throw new IllegalStateException("Oops could not delete camin");
            }
        }, () -> {
            throw new NotFoundException(String.format("Camin with id %s not found", id));
        });
    }

    public Camin getCamin(int id) {
        return caminDao.selectCaminById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Camin with id %s not found", id)));
    }
}
