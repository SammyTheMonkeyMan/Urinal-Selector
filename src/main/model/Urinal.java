package model;

public class Urinal {
    private boolean occupied;

    public Urinal(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void switchOccupied() {
        this.occupied = !occupied;
    }
}
