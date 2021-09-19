package com.heqin.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author heqin
 * @Date 2021/9/8 22:30
 * <p>
 * 干货 | 教你如何监控 Java 线程池运行状态
 * https://mp.weixin.qq.com/s?__biz=MzI3ODcxMzQzMw==&mid=2247485881&idx=1&sn=53e8a0a2031bcd7b4614f7da4c5842b8&chksm=eb538c8fdc240599459ec90ef0aa87430fe786bedb93810426d97154d4aa085fc91bc89cb5c8&scene=21#wechat_redirect
 */
public class ThreadPoolExecutorMonitorStatusDemo {
    private static int capacity = 100000;
    private static ExecutorService executorService = new ThreadPoolExecutor(50, 100, 0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(capacity));

    public static void main(String[] args) {
        for (int i = 0; i < capacity; i++) {
            executorService.execute(() -> {
                System.out.println(1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        if(executorService instanceof ThreadPoolExecutor){
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;
            while (true){
                System.out.println();
                int queueSize = threadPoolExecutor.getQueue().size();
                System.out.println("当前排除线程数：" + queueSize);

                int activeCount = threadPoolExecutor.getActiveCount();
                System.out.println("当前活动线程数：" + activeCount);

                long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
                System.out.println("执行完成线程数：" + completedTaskCount);

                long taskCount = threadPoolExecutor.getTaskCount();
                System.out.println("总线程数：" + taskCount);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
