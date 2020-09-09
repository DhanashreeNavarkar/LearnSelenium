package co.testNG.basics;

import org.testng.annotations.Test;

public class InvocationCount {
	
	//if same tc is to be repeated multiple times
	@Test (invocationCount = 10)
	public void sum() {
		int a = 10;
		int b = 20;
		int c = a+b;
		System.out.println("Sum = "+c);
	}

}
