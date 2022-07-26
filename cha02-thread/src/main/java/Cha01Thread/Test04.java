package Cha01Thread;

import common.Constants;
import common.FileReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ch.Test04")
public class Test04 {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug("running");
                FileReader.read(Constants.TEST_ADDRESS);
            }
        };
//        t1.start();
        t1.run();
        log.debug("do other things");
    }
}
