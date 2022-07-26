package Cha01Thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ch.Test1")
public class Test01 {
    public static void main(String[] args) {
        //创建线程子类
        Thread t = new Thread(){
            //重写任务方法，run方法中写要执行的任务
            @Override
            public void run() {
                log.debug("running");
            }
        };
        //线程命名
        t.setName("t1");
        t.start();
        log.debug("running");
    }
}
