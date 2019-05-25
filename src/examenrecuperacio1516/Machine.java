package examenrecuperacio1516;

public class Machine extends MachineComponent {

    public void setBroken() {
        if(!isBroken()) {
            broken = true;
            setChanged();
            notifyObservers();
        }
    }

    public void repair() {
        if(isBroken()) {
            broken = false;
            setChanged();
            notifyObservers();
        }
    }

    public boolean isBroken() {
        return broken;
    }
}
