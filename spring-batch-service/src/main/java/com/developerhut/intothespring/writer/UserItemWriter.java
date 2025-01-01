package com.developerhut.intothespring.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

import com.developerhut.intothespring.model.User;

public class UserItemWriter implements ItemWriter<User> {

	@Override
	public void write(Chunk<? extends User> chunk) throws Exception {
		
		chunk.forEach(user -> {
			System.out.println("Writer : " + user.toString());
		});
		
	}

}
