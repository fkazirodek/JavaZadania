package c02.ex09;

import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

class Speed {
    private Logger logger = Logger.getLogger(Speed.class.getName());

    private int currentSpeed = 0;
    private int maxSpeed = 250;
    private double currentSpeedInMetersPerSecond = 0;

    public Speed(final int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    void kickDown() {
        if (maxSpeed == currentSpeed + 100) {
            currentSpeed = maxSpeed;
            return;
        }
        for (int i = 0; i < 10; i++) {
            up();
        }
        logger.log(INFO, "Speed increase to " + currentSpeed);
    }

    void up() {
        if (maxSpeed == currentSpeed) {
            logger.log(INFO, "Cannot speed increase, max speed is " + maxSpeed);
            return;
        }

        currentSpeed += 10;
        currentSpeedInMetersPerSecond = SpeedConverted.kmPerHourToMeterPerSecond(currentSpeed);

        logger.log(INFO, "Speed increase to " + currentSpeed);
    }

    void down() {
        if (currentSpeed == 0) {
            throw new IllegalStateException("Current speed cannot be lower than 0");
        }
        currentSpeed -= 10;
        currentSpeedInMetersPerSecond = SpeedConverted.kmPerHourToMeterPerSecond(currentSpeed);

        logger.log(INFO, "Speed decrease to " + currentSpeed);
    }

    public void downToZero() {
        currentSpeed = 0;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    double getInMetersPerSecond() {
        return SpeedConverted.kmPerHourToMeterPerSecond(currentSpeed);
    }
}
