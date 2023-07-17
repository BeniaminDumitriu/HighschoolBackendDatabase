package com.liceu.project.elevi;

import com.liceu.project.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElevService {

    private final EleviDao eleviDao;

    public ElevService(EleviDao eleviDao) {
        this.eleviDao = eleviDao;
    }

    public List<Elev> getElevi() {
        return eleviDao.selectElevi();
    }

    public int addNewElev(Elev elev) {
        int result = eleviDao.insertElev(elev);
        if (result != 1) {
            throw new IllegalStateException("Oops something went wrong");
        }
        return result;
    }

    public void deleteElev(Integer id) {
        Optional<Elev> elevi = eleviDao.selectElevById(id);
        elevi.ifPresentOrElse(elev -> {
            int result = eleviDao.deleteElev(id);
            if (result != 1) {
                throw new IllegalStateException("Oops could not delete elev");
            }
        }, () -> {
            throw new NotFoundException(String.format("Elev with id %s not found", id));
        });
    }

    public Elev getElev(int id) {
        return eleviDao.selectElevById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Elev with id %s not found", id)));
    }

}
