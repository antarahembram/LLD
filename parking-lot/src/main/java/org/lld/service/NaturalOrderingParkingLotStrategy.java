package org.lld.service;

import org.lld.model.Slot;
import org.lld.strategy.ParkingLotStrategy;

import java.util.PriorityQueue;

public class NaturalOrderingParkingLotStrategy implements ParkingLotStrategy {
    private PriorityQueue<Integer> freeSlots;

    public NaturalOrderingParkingLotStrategy(int capacity){
        freeSlots = new PriorityQueue<>(capacity);
        for(int i=1;i<=capacity;i++){
            freeSlots.add(i);
        }
    }
    @Override
    public int getNextFreeSlot() {
        if(freeSlots.isEmpty()){
            return -1;
        }
        return freeSlots.peek();
    }

    @Override
    public void addSlot(int slot) {
        freeSlots.poll();
    }

    @Override
    public void removeSlot(int slot) {
        freeSlots.add(slot);
    }
}
