package com;

import com.example.mowitnow.model.Pelouse;
import com.example.mowitnow.model.Tondeuse;
import com.example.mowitnow.service.TondeuseService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TondeuseServiceTests {

    private final TondeuseService tondeuseService = new TondeuseService();

    @Test
    public void testProcessCommands() {
        Pelouse pelouse = new Pelouse(5, 5);
        Tondeuse tondeuse = new Tondeuse(1, 2, 'N');
        String commands = "GAGAGAGAA";

        String result = tondeuseService.processCommands(pelouse, tondeuse, commands);
        assertEquals("1 3 N", result);
    }
}
