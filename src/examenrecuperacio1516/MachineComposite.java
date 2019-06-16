package examenrecuperacio1516;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class MachineComposite extends MachineComponent implements Observer {
    private List<MachineComponent> components = new ArrayList<>();
    private List<MachineComponent> brokenComponents = new ArrayList<>();


    public void addComponent(MachineComponent mc) {
        if(!components.contains(mc) || brokenComponents.contains(mc)) {
            components.add(mc);
            mc.addObserver(this);
        }
    }
    @Override
    public void setBroken() {
        if (!isBroken()) {
            for (MachineComponent machine :components){
                if (machine.isBroken()){
                    brokenComponents.add(machine);
                    broken = true;
                    setChanged();
                    notifyObservers();
                }
            }
        }
    }
    @Override
    public void repair() {
        if (isBroken()) {
            for (MachineComponent component : brokenComponents) {
                component.repair();
                brokenComponents.remove(component);
            }
            broken = false;
            setChanged();
            notifyObservers();
        }
    }
    @Override
    public boolean isBroken() {
        return broken;
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        MachineComponent mc = (MachineComponent) arg;
        if (mc.isBroken()) {
            if (!brokenComponents.contains(mc))
                brokenComponents.add(mc);
            if (!broken) {
                broken = true;
                setChanged();
                notifyObservers();
            }

        } else if (!mc.isBroken()) {
            brokenComponents.remove(mc);
            if (brokenComponents.isEmpty() && broken) {
                broken = false;
                setChanged();
                notifyObservers();
            }

        }

    }
}
