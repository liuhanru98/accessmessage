package com.shenzhen.teamway.assessctloffivesys;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * @program: assessctloffivesys
 * @description:
 * @author: liuhanru
 * @create: 2019-06-03 17:51
 **/
public class BlockingDemo {
    public static void main(String[] args) throws InterruptedException {
        //阻塞队列
        /*ArrayBlockingQueue<Integer> q= new ArrayBlockingQueue(10);
            q.put(0);
            q.put(0);
        for (int i = 0; i < 3; i++) {
            q.take();
            System.out.println("aa");
        }*/

        //callable demo实现
        ExecutorService callExecutors = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for(int i = 0; i <= 10; i++){
             results.add(callExecutors.submit(new TaskWithResult(i)));
        }
        for(Future<String> fs : results){
            try {
                System.out.println(fs.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

}

class TaskWithResult implements Callable{

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public Object call() throws Exception {
        return "result of TaskWithResult" + id;
    }

}

class Red implements ApplicationContextAware,BeanNameAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void setBeanName(String s) {

    }
}