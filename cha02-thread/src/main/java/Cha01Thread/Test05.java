package Cha01Thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ch.Test05")
public class Test05 {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug("t1状态:{}",this.getState());
            }
        };
        log.debug("t1状态：{}", t1.getState());
        t1.start();
        log.debug("t1状态:{}", t1.getState());
    }
}
