package com.warm.system.common;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author xuchuanqi
 * @date 2022/2/23 21:35.
 */
public class Dic {

    /**
     * 访问次数
     */
    public static int numAcc = 0;
    /**
     * 命中次数
     */
    public static int hitAcc = 0;

    public static ExecutorService pool;
    static {

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        //Common Thread Pool
        pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

//        pool.execute(()-> System.out.println(Thread.currentThread().getName()));
//        pool.shutdown();//gracefully shutdown
    }

}