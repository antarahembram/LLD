package org.lld.model;

public class Slot {
    private Integer slotNumber;
    private Car parkedCar;

    public void setParkedCar(Car parkedCar) {
        this.parkedCar = parkedCar;
    }

    public Slot(final Integer slotNumber) {
        this.slotNumber = slotNumber;
        this.parkedCar = null;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public Car getParkedCar() {
        return parkedCar;
    }
}
