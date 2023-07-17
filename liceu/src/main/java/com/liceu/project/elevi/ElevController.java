package com.liceu.project.elevi;

import com.liceu.project.licee.Liceu;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/elev")
@RequiredArgsConstructor
public class ElevController {
    private final ElevService elevService;

    @PostMapping
    public int addElev(@RequestBody Elev elev) {
        return elevService.addNewElev(elev);
    }

    @CrossOrigin
    @GetMapping
    public List<Elev> getElevi() {
        return elevService.getElevi();
    }

    @CrossOrigin
    @DeleteMapping
    public void deleteElev(@RequestParam Integer id) {
        elevService.deleteElev(id);
    }
}
