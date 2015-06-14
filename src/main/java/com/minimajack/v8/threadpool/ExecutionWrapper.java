package com.minimajack.v8.threadpool;

/**
 * The Class TaskExecutionWrapper.
 */
public class ExecutionWrapper
    implements Runnable
{

    /** The runnable. */
    private final Runnable runnable;

    /**
     * Instantiates a new task execution wrapper.
     * 
     * @param runnable
     *            the runnable
     */
    public ExecutionWrapper( final Runnable runnable )
    {

        this.runnable = runnable;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {

        try
        {
            this.runnable.run();
        }
        catch ( final Exception e )
        {
            e.printStackTrace();
        }
    }
}
