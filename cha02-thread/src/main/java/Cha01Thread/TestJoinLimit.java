package Cha01Thread;


import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ch.TestJoinLimit")
public class TestJoinLimit {
    static int r1 = 0;

    public static void main(String[] args) throws InterruptedException {
//        test03();
        test04();
    }

    public static void test03() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1 = 20;
        }, "t1");
        long start = System.currentTimeMillis();
        t1.start();
        //实际等了1s就等到
        t1.join(1500);
        long end = System.currentTimeMillis();
        log.debug("r1 = {},time gap is {}", r1, end - start);
    }

    public static void test04() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1 = 20;
        }, "t1");
        long start = System.currentTimeMillis();
        t1.start();
        //等了1.5s没等到，直接执行了
        t1.join(1500);
        long end = System.currentTimeMillis();
        log.debug("r1 = {},time gap is {}", r1, end - start);
    }
}
