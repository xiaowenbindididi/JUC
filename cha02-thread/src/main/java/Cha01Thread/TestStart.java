package Cha01Thread;

import common.Constants;
import common.FileReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ch.TestStart")
public class TestStart {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug("Thread name is {}",Thread.currentThread().getName());
                FileReader.read(Constants.TEST_ADDRESS);
            }
        };
        //run
//        t1.run();
        //start
        t1.start();
        log.debug("running");
    }
}
