package co.testNG.basics;

import org.testng.annotations.Test;

public class ExceptionTimeout {
	
	//incase of infinite loops - avoided/not to be used
	
	/*
	 * @Test (invocationTimeOut = 2000, expectedExceptions=NumberFormatException.class) 
	 * public void infiniteLoop() {
	 * int i = 1; 
	 * while(i==1) { 
	 * System.out.println(i);
	 *  } 
	 *  }
	 */	
	@Test(expectedExceptions=NumberFormatException.class)
	public void test() {
		String x= "100A";
		Integer.parseInt(x);
	}
		

}
