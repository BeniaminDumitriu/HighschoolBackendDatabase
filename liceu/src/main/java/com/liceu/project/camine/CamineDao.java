package com.liceu.project.camine;

import java.util.List;
import java.util.Optional;

public interface CamineDao {
    List<Camin> selectCamine();
    int insertCamin(Camin camin);
    int deleteCamin(int id);
    Optional<Camin> selectCaminById(int id);
}
