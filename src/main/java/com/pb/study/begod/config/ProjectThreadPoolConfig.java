package com.pb.study.begod.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author bruli
 * @since 25/12/2021
 */
@Configuration
@Slf4j
public class ProjectThreadPoolConfig {

	/**
	 * 用于处理IO密集的批处理任务的线程池
	 * @return
	 */
	@Bean("projectBatch")
	public ThreadPoolTaskExecutor executor(){
		int cpuNum = Runtime.getRuntime().availableProcessors();
		log.info("cpuNum:{}",cpuNum);
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setQueueCapacity(200);
		executor.setCorePoolSize(cpuNum * 2);
		executor.setMaxPoolSize(cpuNum * 4);
		executor.setThreadFactory(buildFactory());
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		return executor;
	}

	public ThreadFactory buildFactory(){
		return new CustomizableThreadFactory("project-pool-%d");
	}
}
