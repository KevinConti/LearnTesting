public class Calculator {

	private final static String DEFAULT_REGEX = ",|n";

	public static int add(String numbers){
		int sum;

		String[] numbersArray = processUserInputIntoOnlyNumbers(numbers);
		verifyOnlyNumbers(numbersArray);
		sum = computeAnswer(numbersArray);
		
		
		return sum;
	}

	private static String[] processUserInputIntoOnlyNumbers(String numbers){
		//This method needs to clean the input AND determine the appropriate regex

		String regex = determineRegex(numbers);
		boolean inputHasCustomArguments = !regex.equals(DEFAULT_REGEX);
		String inputWithoutUserArguments;
		if (inputHasCustomArguments){
			inputWithoutUserArguments = cleanInput(numbers);
		}
		else{
			inputWithoutUserArguments = numbers;
		}

		String[] numbersArray = inputWithoutUserArguments.split(regex);
		return numbersArray;
	}

	private static String cleanInput(String numbers){
		int userArgsEndIndexExclusive = 4;

		String cleanedInput = numbers.substring(userArgsEndIndexExclusive, numbers.length());

		return cleanedInput;
	}

	private static String determineRegex(String numbers){
		//TODO shorten
		String regex;
		if (numbers.length() > 4) {
			String doubleSlash = "//";
			String possibleDoubleSlash = numbers.substring(0, 2);

			String newLineCharacter = "n";
			String possibleNewLine = numbers.substring(3, 4);

			String possibleCustomDelimiter = numbers.substring(2, 3);

			if (possibleDoubleSlash.equals(doubleSlash) && possibleNewLine.equals(newLineCharacter)) {
				regex = possibleCustomDelimiter + "|" + newLineCharacter;
			} else {
				regex = DEFAULT_REGEX;
			}
		}
		else{
			regex = DEFAULT_REGEX;
		}
		return regex;
	}
	private static void verifyOnlyNumbers(String[] userInput){
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
