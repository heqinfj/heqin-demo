package com.heqin.concurrent;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Desc 测试ArrayBlockingQueue的API
 * @Author heqin
 * @Date 2021/9/9 19:26
 */
public class ArrayBlockingQueueAPI {

    private BlockingQueue<Integer> workQueue;

    @Before
    public void initialize() {
        workQueue = new ArrayBlockingQueue<Integer>(1);
    }

    @Test
    public void add() {
        for (int i = 0; i < 3; i++) {
            //add方法 抛出异常
            workQueue.add(i);
        }
    }

    @Test
    public void offer() {
        for (int i = 0; i < 3; i++) {
            boolean offer = workQueue.offer(i);
            System.out.println(offer);
        }
    }

    @Test
    public void put() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            //put方法 无限期地阻塞当前线程，直到操作成功
            workQueue.put(i);
        }
    }

    @Test
    public void remainingCapacity(){
        int i = workQueue.remainingCapacity();
        System.out.println(i);
    }
}
