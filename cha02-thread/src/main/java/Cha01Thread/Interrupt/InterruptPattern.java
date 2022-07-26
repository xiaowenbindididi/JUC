package Cha01Thread.Interrupt;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ch.InterruptPattern")
public class InterruptPattern {
    public static void main(String[] args) throws InterruptedException {
        InTestInterrupt testInterrupt = new InTestInterrupt();
        testInterrupt.start();

        Thread.sleep(3500);
        log.debug("stop");
        testInterrupt.stop();
    }
}

@Slf4j(topic = "ch.TestInterrupt")
class InTestInterrupt {
    private Thread thread;

    public void start() {
        thread = new Thread(() -> {
            while (true) {
                Thread cur = Thread.currentThread();
                //被打断的情况
                if (cur.isInterrupted()) {
                    log.debug("优雅关闭线程");
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {//捕捉到异常说明
                    cur.interrupt();
                    e.printStackTrace();
                }
            }
        }, "t1");
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

}
