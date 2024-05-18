package org.lld.service;

import org.lld.model.Car;
import org.lld.model.ParkingLot;
import org.lld.model.Slot;
import org.lld.strategy.ParkingLotStrategy;

import java.util.Map;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private ParkingLotStrategy parkingLotStrategy;
    public void createParkingLot(int capacity){
        this.parkingLot = new ParkingLot(capacity);
        this.parkingLotStrategy = new NaturalOrderingParkingLotStrategy(capacity);
    }

    public void parkCar(final Car car){
        int slot = parkingLotStrategy.getNextFreeSlot();
        if(slot == -1) {
            System.out.println("Oops! No more free slot !");
        }
        this.parkingLot.parkCar(car, slot);
        this.parkingLotStrategy.addSlot(slot);
        System.out.println("Car to be parked at slot : "+ slot );
    }

    public void leave(int slot){
        this.parkingLot.relaseCar(slot);
        this.parkingLotStrategy.removeSlot(slot);
        System.out.println("Slot : " + slot + " is released ");
    }

    public void displayParkingLot(){
        this.parkingLot.displayParkingLot();
    }

    public void getSlotFromReg(String reg){
        Map<Integer, Slot> map = parkingLot.getSlots();
        for(Map.Entry<Integer, Slot> e : map.entrySet()){
            Slot slot = e.getValue();
            if(slot.getParkedCar().getRegistrationNumber().equalsIgnoreCase(reg)){
                System.out.println("Car reg " + reg + " slot " + e.getKey());
            }
        }
    }

    public void getAllRegsOfColor(String color) {
        Map<Integer, Slot> map = parkingLot.getSlots();
        for(Map.Entry<Integer, Slot> e : map.entrySet()){
            Slot slot = e.getValue();
            if(slot.getParkedCar().getColor().equalsIgnoreCase(color)){
                System.out.println("Car color " + color + " reg " + slot.getParkedCar().getRegistrationNumber());
            }
        }
    }

}
