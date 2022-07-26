package Cha01Thread.Interrupt;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ch.TestInterrupt02")
public class TestInterrupt02 {
    //尝试打断正常运行的线程
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                log.debug("t1运行中");
                Thread cur = Thread.currentThread();
                boolean interrupted = cur.isInterrupted();
                if (interrupted) {
                    log.debug("被打断");
                    break;
                }
            }
        }, "t1");
        t1.start();
        t1.interrupt();
        log.debug("t1线程的状态是{}",t1.isInterrupted());
    }
}
