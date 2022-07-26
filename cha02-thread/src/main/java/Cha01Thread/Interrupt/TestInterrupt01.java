package Cha01Thread.Interrupt;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ch.TestInterrupt01")
public class TestInterrupt01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        Thread.sleep(1);
        t1.interrupt();
        //打断状态应该是FALSE，因为打断sleep线程，会清空打断状态
        log.debug("打断状态为{}",t1.isInterrupted());
    }
}
