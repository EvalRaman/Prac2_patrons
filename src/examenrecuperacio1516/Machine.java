package examenrecuperacio1516;

public class Machine extends MachineComponent {

    @Override
    public void setBroken() {
        if(!isBroken()) {
            broken = true;
            setChanged();
            notifyObservers(this);
        }
    }
    @Override
    public void repair() {
        if(isBroken()) {
            broken = false;
            setChanged();
            notifyObservers(this);
        }
    }
    @Override
    public boolean isBroken() {
        return broken;
    }
}
