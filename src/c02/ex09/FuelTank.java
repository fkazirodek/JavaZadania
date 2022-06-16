package c02.ex09;

class FuelTank {
    private double tankCapacity;
    private double amountOfFuel = 0;

    public FuelTank(final double tankCapacity, final double amountOfFuel) {
        this.tankCapacity = tankCapacity;
        this.amountOfFuel = amountOfFuel;
    }

    public boolean isEmpty() {
        return amountOfFuel == 0;
    }

    public boolean isNotEmpty() {
        return amountOfFuel != 0;
    }

    public void consumeFuel(double amount) {
        amountOfFuel -= amount;
    }

    public double getAmountOfFuel() {
        return amountOfFuel;
    }

    void refuel(double amount) {
        if (amountOfFuel + amount > tankCapacity) {
            amountOfFuel = tankCapacity;
        } else {
            amountOfFuel += amount;
        }
    }
}
