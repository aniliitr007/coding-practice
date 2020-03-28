package com.akgcloud.java.reactive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Reactive programming is about building asynchronous, non-blocking, and
 * event-driven applications that can easily scale.
 * 
 * Reactive Streams are push-based. It is the Publisher that notifies the
 * Subscriber of newly available values as they come, and this push aspect is
 * key to being reactive.
 * 
 * @author anil.kumar
 *
 */

public class ReactiveProgramming {

	// Publisher, Subscriber, Subscription,

	// Mono, Flux

	// Observable

	public static void main(String[] args) {
		List<Integer> elements = new ArrayList<>();
		Integer[] a = {1, 2, 3, 4};
		List<Integer> list = Arrays.asList(a);
		Flux.just(1, 2, 3, 4)
			.log()
			.map(i->i*2)
			.subscribe(elements::add);
		
		System.out.println(elements);

		// assertThat(elements).containsExactly(1, 2, 3, 4);

	}
	

}
