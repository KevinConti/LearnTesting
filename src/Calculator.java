public class Calculator {

	private final static String DEFAULT_REGEX = ",|n";

	public static int add(String numbers){
		int sum;

		String[] numbersArray = processUserInputIntoOnlyNumbers(numbers);
		checkForZeroNumbers(numbersArray);
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

		return inputWithoutUserArguments.split(regex);
	}

	private static String cleanInput(String numbers){
		int userArgsEndIndexExclusive = 4;

		return numbers.substring(userArgsEndIndexExclusive, numbers.length());
	}

	private static String determineRegex(String numbers){
		String regex = DEFAULT_REGEX;
		if (numbers.length() > 4) {
			regex = checkForCustomRegex(numbers);
		}
		return regex;
	}
	private static String checkForCustomRegex(String numbers){
		String regex;

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

		return regex;
	}

	private static void checkForZeroNumbers(String[] userInput){
		final String ZERO_NUMBERS = "";
		
		if(userInput[0].equals(ZERO_NUMBERS)){
			return;
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
