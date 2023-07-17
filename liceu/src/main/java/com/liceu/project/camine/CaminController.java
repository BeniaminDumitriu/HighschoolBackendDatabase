package com.liceu.project.camine;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/Camine")
@RequiredArgsConstructor
public class CaminController {

    private final CaminService CaminService;

    @PostMapping
    public int addCamin(@RequestBody Camin camin) {
        return CaminService.addNewCamin(camin);
    }
}
