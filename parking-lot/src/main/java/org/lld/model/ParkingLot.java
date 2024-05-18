package org.lld.model;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ParkingLot {
    private int capacity;
    private Map<Integer,Slot> slots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        slots = new HashMap<>(capacity);

        System.out.println("Parking lot is created with capacity " + this.capacity);

    }

    public boolean isFull(){
        if (slots.size() == this.capacity) {
            return true;
        }
        return false;
    }

    public int parkCar(final Car car, int slotNumber) {
        if(!isFull()){
            Slot slot = new Slot(slotNumber);
            slot.setParkedCar(car);
            slots.put(slot.getSlotNumber(), slot);
            return  slot.getSlotNumber();
        } else {
            System.out.println("Oops! No more available slots ! Better luck next time !");
            return -1;
        }
    }

    public void relaseCar(final int slot){
        slots.remove(slot);
    }

    public Map<Integer, Slot> getSlots() {
        return slots;
    }

    public void displayParkingLot(){
        for(Map.Entry<Integer, Slot> e: slots.entrySet()){
            System.out.println(e.getKey() + " "
                    + e.getValue().getParkedCar().getRegistrationNumber() +" "
                    + e.getValue().getParkedCar().getColor());
        }
    }


}
