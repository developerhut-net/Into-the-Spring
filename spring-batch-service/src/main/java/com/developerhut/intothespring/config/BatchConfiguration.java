package com.developerhut.intothespring.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.developerhut.intothespring.listener.JobCompletionNotificationListener;
import com.developerhut.intothespring.model.User;
import com.developerhut.intothespring.processor.UserItemProcessor;
import com.developerhut.intothespring.writer.UserItemWriter;

@Configuration
public class BatchConfiguration {

	@Bean
	public FlatFileItemReader<User> reader() {
		
		return new FlatFileItemReaderBuilder<User>()
				.name("userItemReader")
				.resource(new ClassPathResource("data.csv"))
				.delimited()
				.names("firstName", "lastName")
				.targetType(User.class)
				.build();
	}
	
	@Bean
	public UserItemProcessor processor() {
		return new UserItemProcessor();
	}
	
	@Bean
	public JobCompletionNotificationListener listener() {
		return new JobCompletionNotificationListener();
	}
	
	@Bean
	public UserItemWriter writer() {
		return new UserItemWriter();
	}
	
	@Bean
	public Step step1(JobRepository jobRepository, DataSourceTransactionManager transactionManager,
			FlatFileItemReader<User> reader, UserItemProcessor processor, UserItemWriter writer) {
		
		return new StepBuilder("step1", jobRepository)
				.<User, User>chunk(3, transactionManager)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}
	
	@Bean
	public Job importUserJob(JobRepository jobRepository, Step step1,
			JobCompletionNotificationListener listner) {
		
		return new JobBuilder("importUserJob", jobRepository)
				.listener(listner)
				.start(step1)
				.build();
	}
	
}
