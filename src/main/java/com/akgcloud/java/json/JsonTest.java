package com.akgcloud.java.json;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {

	public static void main(String[] args) throws IOException {

		User user = new User();
		user.setId(1);
		user.setName("aman");
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(user);
		String jsonString = mapper.writeValueAsString(user);
		System.out.println(jsonString);

		User u2 = mapper.readValue(jsonString, User.class);
		System.out.println(u2.getName());

	}

}
