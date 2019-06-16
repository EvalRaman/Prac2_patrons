package examenrecuperacio1516.testing;

import examenrecuperacio1516.Machine;
import examenrecuperacio1516.MachineComposite;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineCompositeTest {
    static private MachineComposite machineComposite;
    static private Machine machine1;
    static private Machine machine2;
    @BeforeAll
    static void prep(){
        machineComposite= new MachineComposite();
        machine1 = new Machine();
        machine2 = new Machine();
    }


    @Test
    void setBroken() {
        machine1.setBroken();
        machineComposite.addComponent(machine1);
        machineComposite.setBroken();
        assertTrue(machineComposite.isBroken());
    }

    @Test
    void repair() {
        machine1.setBroken();
        machine2.setBroken();
        machineComposite.addComponent(machine1);
        machineComposite.addComponent(machine2);
        machineComposite.setBroken();
        machineComposite.repair();
        assertFalse(machineComposite.isBroken());
    }
}