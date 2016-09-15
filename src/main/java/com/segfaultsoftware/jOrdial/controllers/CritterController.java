package com.segfaultsoftware.jOrdial.controllers;

import com.segfaultsoftware.jOrdial.models.Critter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CritterController {

    @RequestMapping("/critters")
    public Critter getCritter(@RequestParam(value="id", required=false) Long id, @RequestParam(value="color", required=false) String color) {
        if (id == null) {
            id = Long.valueOf(234);
        }
        if (color == null) {
            color = "fortune grey";
        }
        return new Critter(id, color);
    }
}