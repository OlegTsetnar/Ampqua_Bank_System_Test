package com.ampqua.utilities;


public final class SleepUtils {


    private static final long SHORT_SLEEP_DURATION_MILLISECONDS = 3000L;

    /** Prevent instantiation. */
    private SleepUtils() { }

        /**
         * Performs a sleep, logging the sleep duration.
         *
         * This method exists partially to avoid ugly try/catch blocks.
         * @param milliseconds amount of time to sleep for
         */
        public static void sleep(long milliseconds) {

            try {
                Thread.sleep(milliseconds);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    /**
     * Sleeps for {@value #SHORT_SLEEP_DURATION_MILLISECONDS} milliseconds.
     */
    public static void shortSleep() {
        sleep(SHORT_SLEEP_DURATION_MILLISECONDS);
    }
}
