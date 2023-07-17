package com.liceu.project.elevi;

import java.util.List;
import java.util.Optional;

public interface EleviDao {
    List<Elev> selectElevi();
    int insertElev(Elev elev);
    int deleteElev(int id);
    Optional<Elev> selectElevById(int id);
}
