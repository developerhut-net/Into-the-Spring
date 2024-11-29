package com.developerhut.intothspring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.developerhut.intothspring.controller.HomeController;

@SpringBootTest
class SpringTestingWebLayerApplicationTests {

	@Autowired
	private HomeController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
		//assertThat(controller).isNull();
	}

}
