package com.segfaultsoftware.jOrdial.services;

import com.segfaultsoftware.jOrdial.models.World;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

@Component
public class WorldService {

    private static long currentId = 0;
    private static World systemWorld = new World();
    public static List<World> cache = new Vector<>(Arrays.asList(systemWorld));

    public World save(World world) {
        world.setId(currentId++);
        cache.add(world);
        return world;
    }

    public List<World> getAll() {
        return cache;
    }
}
