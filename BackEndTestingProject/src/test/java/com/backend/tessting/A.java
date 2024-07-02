package com.backend.tessting;

import practice.B;

public class A {
	/*public static void given() {
		System.out.println("execute given method");
	}

	public static void when() {
		System.out.println("execute when method");
	}

	public static void then() {
		System.out.println("execute then method");
	}
*/
	public static A a() {
		System.out.println("Execute   method a");
		return new A();
	}
	
	public static A b() {
		System.out.println("Execute   method b");
	return  new A();

	}
	
	public  static B c() {
		System.out.println("Execute   method c");
		return new B();

	}
	
}
