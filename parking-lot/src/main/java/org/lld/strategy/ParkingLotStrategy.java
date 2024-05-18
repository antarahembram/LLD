package org.lld.strategy;

public interface ParkingLotStrategy {
    public int getNextFreeSlot();
    public void addSlot(int slot);
    public void removeSlot(int slot);
}
