package c02.ex09;

import java.util.concurrent.TimeUnit;

class Utils {
    static void waitFor(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
