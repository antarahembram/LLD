package org.lld;

import org.lld.model.Car;
import org.lld.service.ParkingLotService;

public class Main {
    public static void main(String[] args) {
        ParkingLotService parkingLotService = new ParkingLotService();
        parkingLotService.createParkingLot(5);
        Car car1 = new Car("A1234", "White");
        Car car2 = new Car("B1234", "Red");
        Car car3 = new Car("C1234", "Red");
        Car car4 = new Car("D1234", "Green");
        Car car5 = new Car("E1234", "Green");
        parkingLotService.parkCar(car1);
        parkingLotService.parkCar(car2);
        parkingLotService.parkCar(car3);
        parkingLotService.displayParkingLot();
        parkingLotService.leave(2);
        parkingLotService.displayParkingLot();

        parkingLotService.parkCar(car4);
        parkingLotService.leave(1);
        parkingLotService.parkCar(car5);
        parkingLotService.parkCar(car1);
        parkingLotService.displayParkingLot();


        parkingLotService.getSlotFromReg("D1234");
        parkingLotService.getAllRegsOfColor("Green");
    }
}