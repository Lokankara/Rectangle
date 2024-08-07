package com.test.malaGupta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class WorkshopTest {

    @Test
    void testRepairMethod() {
        Laptop life = new Laptop();
        Workshop.repair(life);
        String memory = life.memory;
        assertEquals("expectedMemoryValue", memory, "#ME-Q42: %s".formatted(memory));
    }
}
