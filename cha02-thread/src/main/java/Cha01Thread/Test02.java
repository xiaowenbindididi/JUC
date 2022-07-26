package Cha01Thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ch.Test02")
public class Test02 {
    public static void main(String[] args) {
        //创建任务对象
        Runnable r = () -> log.debug("running");
        //创建线程对象，参数1是任务对象，参数2是任务名称
        Thread t2 = new Thread(r, "t2");
        t2.start();
    }
}
