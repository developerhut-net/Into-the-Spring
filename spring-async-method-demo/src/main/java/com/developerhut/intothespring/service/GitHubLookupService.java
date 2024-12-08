package com.developerhut.intothespring.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.developerhut.intothespring.model.Repository;

@Service
public class GitHubLookupService {

	private static final Logger logger = LoggerFactory.getLogger(GitHubLookupService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Async
	public CompletableFuture<Repository> findRepository(String name) throws InterruptedException {
		
		logger.info("Looking up : " + name);
		String url = String.format("https://api.github.com/repos/developerhut-net/%s", name);
		
		Repository repository = restTemplate.getForObject(url, Repository.class);
		
		Thread.sleep(1000);
		
		return CompletableFuture.completedFuture(repository);
		
	}
}
