package com.segfaultsoftware.jOrdial.controllers;

import com.segfaultsoftware.jOrdial.models.World;
import com.segfaultsoftware.jOrdial.services.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorldController {
    @Autowired
    private WorldService worldService;

    @RequestMapping(path = "/worlds", method = RequestMethod.GET)
    public List<World> getWorlds() {
        return worldService.getAll();
    }
}
