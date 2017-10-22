public class Calculator {
	public static int add(String numbers){
		int sum = 0;
		
		String[] numbersArray = numbers.split(",|n");
		verifyAppropriateInput(numbersArray);
		sum = computeAnswer(numbersArray);
		
		
		return sum;
	}
	private static void verifyAppropriateInput(String[] userInput){
		final String ZERO_NUMBERS = "";
		
		if(userInput[0].equals(ZERO_NUMBERS)){
			return;
		}
		else {
			//TODO DRY
			for (String number : userInput){
				Integer.parseInt(number); //Throws exception on fail
			}
		}
		
	}
	private static int computeAnswer(String[] numbersArray){
		int sum = 0;
		if (numbersArray.length == 1 && numbersArray[0] != ""){
			sum = Integer.parseInt(numbersArray[0]);
		}
		else if (numbersArray.length > 1){
			sum = performAddition(numbersArray);
		}
		return sum;
	}
	
	private static int performAddition(String[] numbersArray){
		int sum = 0;
		for (String number : numbersArray){
			sum += Integer.parseInt(number);
		}
		return sum;
	}
}
