package com.minimajack.v8.model;

import java.util.concurrent.atomic.AtomicInteger;

public class CountHolder
{

    private static AtomicInteger count = new AtomicInteger( 0 );

    public static void increment()
    {
        count.incrementAndGet();
    }

    public static void decrement()
    {
        count.decrementAndGet();
    }

    public static int get()
    {
        return count.get();
    }
}
