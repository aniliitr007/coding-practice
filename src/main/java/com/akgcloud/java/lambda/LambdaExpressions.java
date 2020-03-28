package com.akgcloud.java.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

//implementation of Java interfaces with a single method.
public class LambdaExpressions {

	public static void main(String[] args) {
		Comparator<String> lambdaComparator = (o1, o2) -> {
			return o1.compareTo(o2);
		};

		System.out.println(lambdaComparator.compare("hello", "world"));

		List<String> list = new ArrayList<>();

		list.add("one");
		list.add("two");
		list.add("three");

		Collections.sort(list, lambdaComparator);

		System.out.println(list);

		// funtional programming
		// Because the reversed() method returns a lambda (function), the reversed()
		// method is considered a higher order function.
		Comparator<String> reversedComp = lambdaComparator.reversed();
		Collections.sort(list, reversedComp);
		System.out.println(list);

		MyInterface iObj = (text) -> {
			System.out.println("Hello " + text);
		};

		iObj.printIt("aman");
		iObj.defaultMethod();
		MyInterface.staticMethod();

		// functional interface
		Predicate<String> startsWithA = (text) -> text.startsWith("A");
		boolean isPred = startsWithA.test("Anil");
		System.out.println(isPred);

		UnaryOperator<String> uOp = (text) -> {
			return text + ".com";
		};

		String us = uOp.apply("abc");
		System.out.println(us);

	}

}
