package com.hucs.top.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: huchuansai
 * @Date: 2022/3/25 1:52 下午
 * @Description:
 */

/**
 * 1. 当一个任务被提交到线程池时，首先查看线程池的核心线程是否都在执行任务，否就选择一条线程执行任务，是就执行第二步。
 * 2. 查看核心线程池是否已满，不满就创建一条线程执行任务，否则执行第三步。
 * 3. 查看任务队列是否已满，不满就将任务存储在任务队列中(SynchronousQueue同步队直接执行第四步)，否则执行第四步。
 * 4. 查看线程池是否已满，不满就创建一条线程执行任务，否则就按照策略处理无法执行的任务。
 */
@EnableAsync
@Configuration
public class ThreadPoolConfig {

    @Lazy
    @Bean(name = "executor")
    @Primary  // 解决More than one TaskExecutor bean found within the context
    public ThreadPoolTaskExecutor executor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(50);
        taskExecutor.setMaxPoolSize(100);
        taskExecutor.setQueueCapacity(200);
        taskExecutor.setThreadNamePrefix("base executor");
        // 设置拒绝策略rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }
}
