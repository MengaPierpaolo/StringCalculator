package it.uniba.tdd;

public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		if (numbersStr == "")
			return 0;
		int decimal = 0;
		for (int i = 0; i < numbersStr.length(); i++){
			if((numbersStr.charAt(i)==',' && numbersStr.charAt(i+1)=='\n')||(numbersStr.charAt(i)=='\n' && numbersStr.charAt(i+1)==',')) 
				throw new StringCalculatorException();
			if(numbersStr.charAt(i)=='-' && numbersStr.charAt(i+1) >= '0' && numbersStr.charAt(i+1) <= '9')
				throw new StringCalculatorException();
		}
		String[] parts = numbersStr.split("[,\n]");
		for (int i = 0; i < parts.length; i++)
			decimal += Integer.parseInt(parts[i]);
		return decimal;
	}
	
	public int addWithCustomDelimiter(String numbersStr) throws StringCalculatorException {
		if (numbersStr == "")
			return 0;
		int decimal = 0;
		for (int i = 0; i < numbersStr.length(); i++){
			if((numbersStr.charAt(i)==',' && numbersStr.charAt(i+1)=='\n')||(numbersStr.charAt(i)=='\n' && numbersStr.charAt(i+1)==',')) 
				throw new StringCalculatorException();
			if(numbersStr.charAt(i)=='-' && numbersStr.charAt(i+1) >= '0' && numbersStr.charAt(i+1) <= '9')
				throw new StringCalculatorException();
		}
		String splitter=numbersStr.split("\n")[0].substring(2);
		for (int i = 0; i < splitter.length(); i++){
			System.out.println(splitter.charAt(i));
		}
		String[] parts = numbersStr.split("\n")[1].split(splitter);
		for (int i = 0; i < parts.length; i++)
			System.out.println(parts[i]);
		System.out.println();
		for (int i = 0; i < parts.length; i++)
			if(Integer.parseInt(parts[i])<=1000)
				decimal += Integer.parseInt(parts[i]);
		return decimal;
	}
}