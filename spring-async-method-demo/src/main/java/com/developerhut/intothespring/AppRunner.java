package com.developerhut.intothespring;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.developerhut.intothespring.model.Repository;
import com.developerhut.intothespring.service.GitHubLookupService;

@Component
public class AppRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);
	
	@Autowired
	private GitHubLookupService githubLookupService;
	
	@Override
	public void run(String... args) throws Exception {

		CompletableFuture<Repository> page1 = githubLookupService.findRepository("In-Hut-Development");
		CompletableFuture<Repository> page2 = githubLookupService.findRepository("Into-the-Spring");
		CompletableFuture<Repository> page3 = githubLookupService.findRepository("Java-Design-Pattern");
		
		CompletableFuture.allOf(page1, page2, page3);
		
		Repository repository1 = page1.get();
		logger.info(repository1.getName() + " - " + repository1.getDescription());
		
		Repository repository2 = page2.get();
		logger.info(repository2.getName() + " - " + repository2.getDescription());
		
		Repository repository3 = page3.get();
		logger.info(repository3.getName() + " - " + repository3.getDescription());
		
	}

}
