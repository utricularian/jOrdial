package com.segfaultsoftware.jOrdial.models;

import com.google.common.base.Objects;

public class World {
    private String name;
    private long cycleNumber;
    private long numberOfCritters;
    private Long id;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCycleNumber(long cycleNumber) {
        this.cycleNumber = cycleNumber;
    }

    public long getCycleNumber() {
        return cycleNumber;
    }

    public void setNumberOfCritters(long numberOfCritters) {
        this.numberOfCritters = numberOfCritters;
    }

    public long getNumberOfCritters() {
        return numberOfCritters;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }

        final World other = (World) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id, this.name);
    }
}
