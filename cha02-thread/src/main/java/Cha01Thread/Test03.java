package Cha01Thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "ch.Test03")
public class Test03 {
    //利用FutureTask创建线程，优点是方便得到返回值
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("call");
                Thread.sleep(3000);
                return 55;
            }
        });
        Thread t = new Thread(task,"t1");
        t.start();
        log.debug("返回结果是{}",task.get());
    }
}
