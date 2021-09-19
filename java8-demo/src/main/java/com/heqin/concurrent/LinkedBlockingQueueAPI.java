package com.heqin.concurrent;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Desc 测试LinkedBlockingQueue的API
 * @Author heqin
 * @Date 2021/9/9 22:23
 */
public class LinkedBlockingQueueAPI {
    private BlockingQueue<Integer> workQueue;

    @Before
    public void initialize() {
        workQueue = new LinkedBlockingQueue<>();
    }

    @Test
    public void remainingCapacity(){
        int remainingCapacity = workQueue.remainingCapacity();
        System.out.println(remainingCapacity);
    }
}
