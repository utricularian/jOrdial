package com.segfaultsoftware.jOrdial.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.segfaultsoftware.jOrdial.builders.WorldBuilder;
import com.segfaultsoftware.jOrdial.models.World;
import com.segfaultsoftware.jOrdial.services.WorldService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class WorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WorldService worldService;

    private WorldBuilder worldBuilder;

    @Before
    public void setUp() {
        worldBuilder = new WorldBuilder();
        worldService.cache.clear();
    }

    @Test
    public void index_shouldReturnListOfWorlds() throws Exception {
        World world1 = worldBuilder.build();
        World world2 = worldBuilder.setName(world1.getName() + " too").build();
        this.worldService.save(world1);
        this.worldService.save(world2);

        MvcResult result = this.mockMvc.perform(get("/worlds")).andExpect(status().isOk()).andReturn();

        String jsonAsString = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<World> worldsFromApi = objectMapper.readValue(jsonAsString, new TypeReference<List<World>>() {});

        assertThat(worldsFromApi).containsOnly(world1, world2);

        World world1FromApi = worldsFromApi.get(0);
        assertThat(world1FromApi).isEqualToComparingOnlyGivenFields(world1,
                "id", "name", "numberOfCritters", "cycleNumber");
    }

    @Test
    public void index_whenNoWorlds_shouldReturnEmptyArray() throws Exception {
        this.mockMvc.perform(get("/worlds")).
                andExpect(status().isOk()).
                andExpect(content().string("[]"));

    }

}
