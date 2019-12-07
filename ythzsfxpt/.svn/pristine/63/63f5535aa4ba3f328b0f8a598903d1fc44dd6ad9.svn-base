package com.inspur.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskDemo extends TimerTask {
    static int sum = 1;

    @Override
    public void run() {
        System.out.println("----task2 start--------"+new Date().toLocaleString());
        try {
            Thread.sleep(5000);
            Map<String,Integer> s = sum();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----5s later, task2 end--------"+new Date().toLocaleString());
    }

    public Map<String,Integer> sum(){
         sum++;
        Map<String,Integer> map = new HashMap<String,Integer>();
        System.out.println(sum);
        map.put("name",sum);
        return map;
    }
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);//启用2个线程

        TaskDemo t1 = new TaskDemo();
        // 立即执行，任务消耗3秒，执行结束后等待2秒，【有空余线程时】，再次执行该任务
        pool.scheduleWithFixedDelay(t1, 0, 2, TimeUnit.SECONDS);
        //
        //// 立即执行，任务消耗5秒，执行结束后等待2秒，【有空余线程时】，再次执行该任务
        //Task2 t2 = new Task2();
        //pool.scheduleWithFixedDelay(t2, 0, 2, TimeUnit.SECONDS);
    }
}
