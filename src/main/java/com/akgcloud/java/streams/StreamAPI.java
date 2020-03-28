package com.akgcloud.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI {

	// Terminal and Non-Terminal Operations
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Example 1");
		list.add("Example 2");
		list.add("Example 3");

		Stream<String> stream = list.stream();

		// Non-Terminal operation
		Stream<String> lowercase = stream.map(elem -> {
			return elem.toLowerCase();
		});
		// Stream<String> lowercase = stream.map(String::toLowerCase);

		// Terminal operation
		lowercase.forEach(element -> {
			System.out.println(element);
		});

	}

}
