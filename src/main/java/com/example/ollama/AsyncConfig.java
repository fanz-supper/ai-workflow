package com.example.ollama;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfig {

    @Bean(name = "asyncExecutor")
    public ThreadPoolTaskExecutor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10); // Number of core threads
        executor.setMaxPoolSize(20); // Maximum number of threads
        executor.setQueueCapacity(100); // Queue size for pending tasks
        executor.setThreadNamePrefix("AsyncThread-"); // Thread name prefix
        executor.setWaitForTasksToCompleteOnShutdown(true); // Wait for tasks to complete on shutdown
        executor.setAwaitTerminationSeconds(60); // Max wait time for shutdown
        executor.initialize();
        return executor;
    }
}