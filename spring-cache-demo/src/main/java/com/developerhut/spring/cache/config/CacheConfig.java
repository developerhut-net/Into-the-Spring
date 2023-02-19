package com.developerhut.spring.cache.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.developerhut.spring.cache.model.Department;
import com.developerhut.spring.cache.service.DepartmentService;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfig {

	@Autowired
	private CacheManager cacheManager;
	
	@Autowired
	DepartmentService departmentService;
	
	@PostConstruct
	public void preloadCache() {
		
		Cache cache = cacheManager.getCache("applicationCache");
		
		System.out.println("****** Initializing Cache");
		
		List<Department> deptList = departmentService.getAll();
		
		for (Department department : deptList) {
			cache.put(department.getId(), department);
		}
	}
	
	@Scheduled(fixedRate=15000, initialDelay=15000)
	public void clearCache() {
		System.out.println("****** clearing the Cache");
		cacheManager.getCacheNames().parallelStream().forEach(
				name -> cacheManager.getCache(name).clear()
				);
	}
	
}
