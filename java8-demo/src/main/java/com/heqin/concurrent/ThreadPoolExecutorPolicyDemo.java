package com.heqin.concurrent;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Author heqin
 * @Date 2021/9/8 20:45
 * @Desc ThreadPoolExecutor的默认拒绝执行处理程序
 * <p>
 * Java 线程池 8 大拒绝策略，面试必问！
 * https://cloud.tencent.com/developer/article/1520860
 */
public class ThreadPoolExecutorPolicyDemo {

    BlockingQueue<Runnable> workQueue;

    ThreadPoolExecutor threadPoolExecutor;

    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(1);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 100,
                TimeUnit.NANOSECONDS, workQueue, Executors.defaultThreadFactory());
        //1. 被拒绝任务的处理程序，它直接在execute方法的调用线程中运行被拒绝的任务，除非执行程序已关闭，在这种情况下任务将被丢弃。
        ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor.AbortPolicy abortPolicy = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor.DiscardPolicy discardPolicy = new ThreadPoolExecutor.DiscardPolicy();
        ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
        threadPoolExecutor.setRejectedExecutionHandler(abortPolicy);
        threadPoolExecutor.submit(new Task("听"));
        threadPoolExecutor.submit(new Task("说"));
        threadPoolExecutor.submit(new Task("读"));
        threadPoolExecutor.submit(new Task("写"));
        threadPoolExecutor.shutdown();
    }

    @Before
    public void initialize() {
        workQueue = new ArrayBlockingQueue<Runnable>(1);
        /**
         * corePoolSize：核心池大小（要保留在池中的线程数），设置为1
         * maximumPoolSize：最大池大小（池中允许的最大线程数），设置为2
         * workQueue：用于在执行任务之前保存任务的队列，此队列容量（capacity）设置为1
         */
        threadPoolExecutor = new ThreadPoolExecutor(1, 2, 100,
                TimeUnit.NANOSECONDS, workQueue, Executors.defaultThreadFactory());
    }

    @Test
    public void callerRunsPolicy() {
        //1. 被拒绝任务的处理程序，它直接在execute方法的调用线程中运行被拒绝的任务，除非执行程序已关闭，在这种情况下任务将被丢弃。
        ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();
        threadPoolExecutor.setRejectedExecutionHandler(callerRunsPolicy);
        handleComm();
    }

    @Test
    public void abortPolicy() {
        //2. 抛出RejectedExecutionException拒绝任务的处理程序。
        ThreadPoolExecutor.AbortPolicy abortPolicy = new ThreadPoolExecutor.AbortPolicy();
        threadPoolExecutor.setRejectedExecutionHandler(abortPolicy);
        handleComm();
    }

    @Test
    public void discardPolicy() {//??? 怎么与在main中执行的不一样
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        System.out.println(String.format("线程%s执行当前方法%s",Thread.currentThread().getName(),stackTrace[1].getMethodName()));

        //3. 被拒绝任务的处理程序，它默默地丢弃被拒绝的任务。
        ThreadPoolExecutor.DiscardPolicy discardPolicy = new ThreadPoolExecutor.DiscardPolicy();
        threadPoolExecutor.setRejectedExecutionHandler(discardPolicy);
        threadPoolExecutor.submit(new Task("听"));
        threadPoolExecutor.submit(new Task("说"));
        threadPoolExecutor.submit(new Task("读"));
        threadPoolExecutor.submit(new Task("写"));
        threadPoolExecutor.shutdown();
    }

    @Test
    public void discardOldestPolicy() {
        //4. 被拒绝任务的处理程序，丢弃最早的未处理请求，然后重试execute ，除非执行程序关闭，在这种情况下任务将被丢弃
        ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
        threadPoolExecutor.setRejectedExecutionHandler(discardOldestPolicy);
        handleComm();
    }

    private void handleComm() {
        //Future<?> future = threadPoolExecutor.submit(new Task());
        threadPoolExecutor.submit(new Task("听"));
        threadPoolExecutor.submit(new Task("说"));
        threadPoolExecutor.submit(new Task("读"));
        threadPoolExecutor.submit(new Task("写"));
        threadPoolExecutor.shutdown();
    }

    static class Task implements Runnable {
        private String taskName;

        public Task(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            long begin = System.currentTimeMillis();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("当前任务【%s】由线程【%s】处理完成，耗时%s毫秒", taskName, Thread.currentThread().getName(), System.currentTimeMillis() - begin));
        }
    }
}
