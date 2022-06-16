package c02.ex09;

import java.util.logging.Logger;

import static java.util.logging.Level.*;

class Car {

    private static final int DEFAULT_TANK_CAPCITY = 50;
    private static final int DEFAULT_FUEL_CONSUMPTION = 8;

    private Logger logger = Logger.getLogger(Car.class.getName());

    private final FuelTank fuelTank;
    private final int avgFuelConsumption;
    private Distance distance;
    private Speed speed;
    private boolean driving = false;
    private boolean stop = false;

    public Car() {
        this.fuelTank = new FuelTank(DEFAULT_TANK_CAPCITY, 0);
        this.avgFuelConsumption = DEFAULT_FUEL_CONSUMPTION;
        this.speed = new Speed(250);
    }

    public Car(final int tankCapacity, final int avgFuelConsumption) {
        this.fuelTank = new FuelTank(tankCapacity, 0);
        this.avgFuelConsumption = avgFuelConsumption;
        this.speed = new Speed(250);
    }

    void drive() {
        if (driving) {
            throw new IllegalStateException("Car is driving");
        }
        if (fuelTank.isEmpty()) {
            throw new EmptyFuelException("Fill up the tank");
        }
        driving = true;
        speed.kickDown();
        distance = new Distance();

        logger.log(INFO, "Start driving with speed " + speed.getCurrentSpeed() + "km/h");

        distance.startWith(speed.getInMetersPerSecond());

        do {
            Utils.waitFor(1);
            double travelledDistance = distance.calculate();
            consumeFuel(travelledDistance);
            logger.log(INFO, "Travelled distance " + travelledDistance + "m");
            logger.log(INFO, "Remaining fuel amount " + fuelTank.getAmountOfFuel() + "l");
            checkIsFuelInTank();
        } while (!stop || fuelTank.isNotEmpty());
    }

    void speedUp() {
        speed.up();
        distance.onSpeedChanged(speed.getInMetersPerSecond());
    }

    void speedDown() {
        if (speed.getCurrentSpeed() == 0) {
            logger.log(INFO, "Car stopped");
            return;
        }
        speed.down();
        distance.onSpeedChanged(speed.getInMetersPerSecond());
    }

    void stop() {
        stop = true;
        distance.stop();
    }

    double getTravelledDistance() {
        return distance.calculate();
    }

    void refuel(double amount) {
        fuelTank.refuel(amount);
        logger.log(INFO, "Amount of fuel increase to " + fuelTank.getAmountOfFuel());
    }

    private void consumeFuel(final double travelledDistance) {
        if (Math.round(travelledDistance % 1000) == 0) {
            fuelTank.consumeFuel(avgFuelConsumption / 100.0);
        }
    }

    private void checkIsFuelInTank() {
        if (fuelTank.isEmpty()) {
            logger.log(INFO, "Tank is empty, car is stopped");
            stop = true;
            speed.downToZero();
        }
    }
}