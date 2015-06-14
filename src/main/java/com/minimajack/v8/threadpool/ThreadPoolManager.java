package com.minimajack.v8.threadpool;

import java.util.concurrent.ScheduledFuture;

/**
 * The Interface ThreadPoolManager.
 */
public interface ThreadPoolManager
{

    /**
     * Schedule.
     * 
     * @param r
     *            the r
     * @param delay
     *            the delay
     * @return the scheduled future
     */
    ScheduledFuture<?> schedule( Runnable r, long delay );

    /**
     * Schedule at fixed rate.
     * 
     * @param r
     *            the r
     * @param delay
     *            the delay
     * @param period
     *            the period
     * @return the scheduled future
     */
    ScheduledFuture<?> scheduleAtFixedRate( Runnable r, long delay, long period );

    /**
     * Execute instant.
     * 
     * @param r
     *            the r
     */
    void executeInstant( Runnable r );

    /**
     * Purges all thread pools.
     */
    void purge();

    void start();

    void stop();

}
