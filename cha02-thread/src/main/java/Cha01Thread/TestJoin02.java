package Cha01Thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ch.TestJoin02")
public class TestJoin02 {
    static int r1 = 0;
    static int r2 = 0;

    public static void main(String[] args) throws InterruptedException {
        test02();
    }

    public static void test02() throws InterruptedException {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                r1 += 10;
            }
        };
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                try {
                    sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                r2 += 20;
            }
        };
        long startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        t2.join();
        t1.join();
        long endTime = System.currentTimeMillis();
        //预期是10,20,4
        log.debug("r1:{},r2:{},cost:{}",r1,r2,endTime - startTime);
    }
}
