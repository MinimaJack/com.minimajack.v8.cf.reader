package com.minimajack.v8.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CommonThreadPoolManager implements ThreadPoolManager {

	private static ThreadPoolManager instance = null;
	/** The scheduled pool. */
	private ScheduledThreadPoolExecutor scheduledPool;

	/** The instant pool. */
	private ThreadPoolExecutor instantPool;

	/** The Constant MAX_DELAY. */
	private static final long MAX_DELAY = TimeUnit.NANOSECONDS
			.toMillis(Long.MAX_VALUE - System.nanoTime()) / 2;

	private CommonThreadPoolManager() {

	}

	@Override
	public void start() {

		final int scheduledPoolSize = 1;
		this.scheduledPool = new ScheduledThreadPoolExecutor(scheduledPoolSize);
		this.scheduledPool.prestartAllCoreThreads();

		final int instantPoolSize = 4;
		this.instantPool = new ThreadPoolExecutor(instantPoolSize,
				instantPoolSize, 0, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(50000));
		this.instantPool.prestartAllCoreThreads();
	}

	@Override
	public void stop() {

		this.instantPool.shutdownNow();
		this.scheduledPool.shutdownNow();
	}

	public synchronized static ThreadPoolManager getInstance() {
		if (instance == null) {
			instance = new CommonThreadPoolManager();
			instance.start();
		}
		return instance;
	}

	/**
	 * Validate.
	 * 
	 * @param delay
	 *            the delay
	 * @return the long
	 */
	private final long validate(final long delay) {

		return Math.max(0, Math.min(MAX_DELAY, delay));
	}

	@Override
	public final ScheduledFuture<?> schedule(final Runnable r, final long delay) {

		return this.scheduledPool.schedule(new ExecutionWrapper(r),
				validate(delay), TimeUnit.MILLISECONDS);
	}

	@Override
	public final ScheduledFuture<?> scheduleAtFixedRate(final Runnable r,
			final long delay, final long period) {

		return this.scheduledPool.scheduleAtFixedRate(new ExecutionWrapper(r),
				validate(delay), validate(period), TimeUnit.MILLISECONDS);
	}

	@Override
	public final void executeInstant(final Runnable r) {

		this.instantPool.execute(new ExecutionWrapper(r));
	}

	@Override
	public void purge() {

		this.scheduledPool.purge();
		this.instantPool.purge();
	}

}
