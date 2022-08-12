package com.hucs.top.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: huchuansai
 * @Date: 2022/8/11 1:56 PM
 * @Description:
 */
@Slf4j
@Component
@EnableScheduling
public class SystemJob {

    @Scheduled(initialDelay = 1000 * 60, fixedRate = 1000 * 60)
    public void exampleTask() {
        log.info("exampleTask execute .....");
    }

}
