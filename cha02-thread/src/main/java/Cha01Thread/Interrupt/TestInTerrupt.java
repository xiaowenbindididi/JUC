package Cha01Thread.Interrupt;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ch.TestInterrupt")
public class TestInTerrupt {
    public static void main(String[] args) throws InterruptedException {
        //lambda表达式代替Runnable实现类
        Thread t1 = new Thread(() -> {
            log.debug("sleep.....");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        log.debug("Interrupt");
        //打断t1线程
        t1.interrupt();
        Thread.sleep(1000);
        boolean interrupted = t1.isInterrupted();
        //对于sleep.wait,join的打断，打断标记为假
        log.debug("打断标记:{}",interrupted);
    }
}
