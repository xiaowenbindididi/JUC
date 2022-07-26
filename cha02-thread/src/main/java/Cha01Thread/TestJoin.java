package Cha01Thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ch.TestJoin")
public class TestJoin {
    static int r = 0;

    public static void main(String[] args) throws InterruptedException {
        test01();
    }

    public static void test01() throws InterruptedException {
        log.debug("开始");
        Thread t1 = new Thread(){
            @Override
            public void run() {
                log.debug(Thread.currentThread().getName() + "开始");
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                r++;
                log.debug(Thread.currentThread().getName() + "结束");
            }
        };
        t1.start();
        //如果想加1,那么就得等t1线程执行结束
        t1.join();
        log.debug("结果为{}",r);
        log.debug("结束");
    }
}
