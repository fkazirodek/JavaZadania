package c02.ex09;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.NavigableMap;
import java.util.TreeMap;

import static java.util.Objects.requireNonNullElseGet;

class Distance {
    private int distanceTraveled;
    private NavigableMap<TimeRange, Double> timeRangeToSpeed = new TreeMap<>();

    void startWith(double speedMetersPerSecond) {
        distanceTraveled = 0;
        timeRangeToSpeed = new TreeMap<>();
        timeRangeToSpeed.put(
                new TimeRange(LocalDateTime.now(), null),
                speedMetersPerSecond
        );
    }

    void onSpeedChanged(double speedMetersPerSecond) {
        LocalDateTime now = LocalDateTime.now();
        timeRangeToSpeed.lastEntry().getKey().setTo(now);

        timeRangeToSpeed.put(
                new TimeRange(now, null),
                speedMetersPerSecond
        );
    }

    void stop() {
        timeRangeToSpeed.lastEntry().getKey().setTo(LocalDateTime.now());
    }

    double calculate() {
        distanceTraveled = 0;
        timeRangeToSpeed.forEach((k, v) -> distanceTraveled += k.getRangeInSeconds() * v);
        return distanceTraveled;
    }
}

class TimeRange implements Comparable<TimeRange> {

    private LocalDateTime from;
    private LocalDateTime to;

    public TimeRange(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    long getRangeInSeconds() {
        return ChronoUnit.SECONDS.between(from, requireNonNullElseGet(to, LocalDateTime::now));
    }

    public void setTo(final LocalDateTime to) {
        this.to = to;
    }


    @Override
    public int compareTo(final TimeRange o) {
        return this.from.compareTo(o.from);
    }
}
