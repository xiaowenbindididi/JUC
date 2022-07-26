package Cha01Thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ch.TestYield")
public class TestYield {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                int count = 0;
                for (;;) {
                    System.out.println("---->1 " + count++);
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (true) {
                    Thread.yield();
                    System.out.println("              ---->2 " + count++);
                }
            }
        };
        Thread t1 = new Thread(r1,"t1");
        Thread t2 = new Thread(r2,"t2");
//        t1.setPriority(10);
//        t2.setPriority(1);
        t1.start();
        t2.start();
    }
}
