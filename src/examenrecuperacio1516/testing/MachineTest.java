package examenrecuperacio1516.testing;

import examenrecuperacio1516.Machine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
class MachineTest {
    static Machine machine;
    @BeforeAll
    static void prep(){
        machine= new Machine();
    }

    @Test
    void setBroken() {
        machine.setBroken();
        assertTrue(machine.isBroken());
    }

    @Test
    void repair() {
        machine.setBroken();
        machine.repair();
        assertFalse(machine.isBroken());
    }

    @Test
    void isBroken() {
        machine.setBroken();
        assertTrue(machine.isBroken());
        machine.setBroken();
        assertTrue(machine.isBroken());

        machine.repair();
        assertFalse(machine.isBroken());
        machine.repair();
        assertFalse(machine.isBroken());

    }
}