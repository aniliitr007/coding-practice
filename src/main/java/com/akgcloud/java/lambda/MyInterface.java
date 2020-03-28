package com.akgcloud.java.lambda;

/**
 * A functional interface in Java is an interface that contains only a single
 * abstract (unimplemented) method. A functional interface can contain default
 * and static methods
 * 
 * @author anil.kumar
 *
 */
public interface MyInterface {

	public void printIt(String str);

	public default void defaultMethod() {
		System.out.println("default method");
	}

	static void staticMethod() {
		System.out.println("static method");
	}

}
