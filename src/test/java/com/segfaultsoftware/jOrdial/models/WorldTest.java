package com.segfaultsoftware.jOrdial.models;

import com.google.common.testing.EqualsTester;
import com.segfaultsoftware.jOrdial.builders.WorldBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WorldTest {

    @Test
    public void equals_shouldCompareRelevantFields() {

        WorldBuilder worldBuilder = new WorldBuilder();

        World original = worldBuilder.setId(4l).setName("foobar").build();
        World copyOfOriginal = worldBuilder.setId(4l).setName("foobar").build();
        World changedName = worldBuilder.setId(4l).setName("barbaz").build();
        World changedId = worldBuilder.setId(5l).setName("foobar").build();
        World nullId = worldBuilder.setId(null).setName("foobar").build();

        new EqualsTester()
                .addEqualityGroup(original, copyOfOriginal)
                .addEqualityGroup(changedName)
                .addEqualityGroup(changedId)
                .addEqualityGroup(nullId)
                .testEquals();
    }

    @Test
    public void hashCode_shouldProduceUniqueValues() {
        WorldBuilder worldBuilder = new WorldBuilder();

        World original = worldBuilder.setId(4l).setName("foobar").build();
        World copyOfOriginal = worldBuilder.setId(4l).setName("foobar").build();
        World changedName = worldBuilder.setId(4l).setName("barbaz").build();
        World changedId = worldBuilder.setId(5l).setName("foobar").build();

        assertThat(original.hashCode()).isEqualTo(copyOfOriginal.hashCode());
        assertThat(original.hashCode()).isNotEqualTo(changedName.hashCode());
        assertThat(original.hashCode()).isNotEqualTo(changedId.hashCode());
    }
}
