package it.uniba.tdd.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.uniba.tdd.StringCalculator;
import it.uniba.tdd.StringCalculatorException;

public class StringCalculatorTest {
	StringCalculator stringCalculator;

	@Before
	public void newStringCalculator() {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void testEmptyString() throws StringCalculatorException {
		Assert.assertEquals(0, stringCalculator.add(""));
	}

	@Test
	public void testOneStringNumberOne() throws StringCalculatorException {
		Assert.assertEquals(1, stringCalculator.add("1"));
	}

	@Test
	public void testOneStringNumberTwo() throws StringCalculatorException {
		Assert.assertEquals(2, stringCalculator.add("2"));
	}

	@Test
	public void testOneStringNumber2000() throws StringCalculatorException {
		Assert.assertEquals(2000, stringCalculator.add("2000"));
	}

	@Test
	public void testOnePlusOne() throws StringCalculatorException {
		Assert.assertEquals(2, stringCalculator.add("1,1"));
	}

	@Test
	public void testOnePlus999() throws StringCalculatorException {
		Assert.assertEquals(1000, stringCalculator.add("1,999"));
	}
	
	@Test
	public void testThreeNumbers() throws StringCalculatorException {
		Assert.assertEquals(2000, stringCalculator.add("1,999\n1000"));
	}

	@Test
	public void testOnePlus999WithNewLine() throws StringCalculatorException {
		Assert.assertEquals(1000, stringCalculator.add("1\n999"));
	}

	@Test(expected = StringCalculatorException.class)
	public void testInvalidStringWithCommaAndNewLine() throws StringCalculatorException {
		stringCalculator.add("1,\n999");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void testInvalidStringWithNewLineAndComma() throws StringCalculatorException {
		stringCalculator.add("1\n,9");
	}
	
	@Test
	public void testTheCustomDelimiter() throws StringCalculatorException {
		Assert.assertEquals(3, stringCalculator.addWithCustomDelimiter("//;\n1;2"));
	}
	
	@Test
	public void testIgnoreNumbersOver1000() throws StringCalculatorException {
		Assert.assertEquals(2, stringCalculator.addWithCustomDelimiter("//;\n1200;2"));
	}
	
	@Test(expected = StringCalculatorException.class)
	public void testInvalidNegativeNumber() throws StringCalculatorException {
		stringCalculator.add("1,-1");
	}
	
	@Test
	public void testTheCustomDelimiterLengthOf3() throws StringCalculatorException {
		Assert.assertEquals(6, stringCalculator.addWithCustomDelimiter("//[***]\n1***2***3"));
	}

}
