package com.segfaultsoftware.jOrdial.builders;


import com.github.javafaker.Faker;
import com.segfaultsoftware.jOrdial.models.World;

public class WorldBuilder {

    private Faker faker;
    private String name;
    private long numberOfCritters;
    private long cycleNumber;
    private Long id;

    public WorldBuilder() {
        this.faker = new Faker();
        this.name = faker.name().name();
        this.numberOfCritters = faker.number().numberBetween(1, 10000);
        this.cycleNumber = faker.number().numberBetween(1, 3000);
    }

    public WorldBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public WorldBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public World build() {
        World world = new World();
        world.setName(this.name);
        world.setCycleNumber(this.cycleNumber);
        world.setNumberOfCritters(this.numberOfCritters);

        if (this.id != null) {
            world.setId(this.id);
        }
        return world;
    }
}
