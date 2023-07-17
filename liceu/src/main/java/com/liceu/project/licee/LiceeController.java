package com.liceu.project.licee;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/liceu")
public class LiceeController {

    private final LiceuService liceuService;

    @CrossOrigin
    @PostMapping
    public int addLiceu(@RequestBody Liceu liceu) {
        return liceuService.addNewLiceu(liceu);
    }

    @CrossOrigin
    @GetMapping
    public List<Liceu> getLicei() {
        return liceuService.getLicei();
    }

    @CrossOrigin
    @DeleteMapping
    public void deleteLiceu(@RequestParam Integer id) {
        liceuService.deleteLiceu(id);
    }

    }
