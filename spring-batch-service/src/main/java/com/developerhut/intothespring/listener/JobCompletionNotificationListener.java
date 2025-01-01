package com.developerhut.intothespring.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobCompletionNotificationListener implements JobExecutionListener {

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("!!! JOB FINISHED with Status " + jobExecution.getStatus());
	}

}
