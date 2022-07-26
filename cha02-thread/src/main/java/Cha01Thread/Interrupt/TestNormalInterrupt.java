package Cha01Thread.Interrupt;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ch.TestNormalInter")
public class TestNormalInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                log.debug("运行");
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted) {
                    log.debug("被打断喽");
                    break;
                }
            }
        }, "t1");
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        log.debug("打断标记为{}", t1.isInterrupted());
    }
}
