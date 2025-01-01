package com.developerhut.intothespring.processor;

import org.springframework.batch.item.ItemProcessor;

import com.developerhut.intothespring.model.User;

public class UserItemProcessor implements ItemProcessor<User, User> {

	@Override
	public User process(User user) throws Exception {
		
		String firstName = user.getFirstName().toUpperCase();
		String lastName = user.getLastName().toUpperCase();
		
		User trasformedUser = new User(firstName, lastName);
		
		System.out.println("Converting (" + user + ") into (" + trasformedUser + ")");
		
		return trasformedUser;
	}

	
}
