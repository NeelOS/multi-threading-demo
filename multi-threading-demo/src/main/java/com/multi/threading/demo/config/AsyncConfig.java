package com.multi.threading.demo.config;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class AsyncConfig implements AsyncConfigurer {

	@Bean("multiThreadingExecutor")
	ThreadPoolTaskExecutor executor() {
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		final int corePoolSize = 10;
		final int maxPoolSize = 50;
		final int awaitTerminationSeconds = 5;
		final int queueCapacity = 10;
		final String threadPrefix = "multi-threading-demo";
		executor.setCorePoolSize(corePoolSize);
		executor.setMaxPoolSize(maxPoolSize);
		executor.setQueueCapacity(queueCapacity);
		executor.setThreadNamePrefix(threadPrefix);
		executor.setAwaitTerminationSeconds(awaitTerminationSeconds);
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.initialize();
		return executor;
	}

	public Executor getAsyncExecutor() {
		return executor();
	}

	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return (ex, method, params) -> {
			log.error("Exception msg thrown from async method :{}", ex.getMessage());
			log.error("Async method name that threw the exception : {}", method.toString());
			log.error("Parameters used to invoke the async method : {}", Arrays.toString(params));
		};
	}
}
