package com.akgcloud.java;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class RxJavaExample {
	
	// Observable
	
	//OnNext, OnError, and OnCompleted

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hello");

		List<Integer> intergerList = Arrays.asList(54, 12, 10, 78, 69, 33, 66, 99, 84);
		Observable.fromIterable(intergerList)
			.filter(i -> i % 2 == 0)
			.sorted()
			.subscribe(i -> System.out.println(i),
						throwable -> throwable.printStackTrace(), 
						() -> System.out.println("Emittion completes"));

	}

}
