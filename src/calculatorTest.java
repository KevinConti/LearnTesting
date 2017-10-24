import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


//Requirement 1: The method can take 0, 1, or 2
//numbers separated by a comma

//Requirement 2: For an empty string, the method will return 0

//Requirement 3: The method will return the sum of the numbers

//Requirement 4: Allow the Add method to handle an unknown amount of numbers

//Requirement 5: Allow the Add method to handle new lines between numbers (instead of commas).
public class calculatorTest {
	
	@Test
	public void whenMoreThan2NumbersAreUsedThenNoExceptionIsThrown() {
		Calculator.add("1,2,3,5,67");
	}
	@Test
	public void when2NumbersAreUsedThenNoExceptionIsThrown(){
		Calculator.add("1,2");
		assertTrue(true);
	}
	@Test
	public void when1NumberIsUsedThenNoExceptionIsThrown(){
		Calculator.add("1");
		assertTrue(true);
	}
	@Test
	public void when0NumbersAreUsedThenNoExceptionIsThrown(){
		Calculator.add("");
		assertTrue(true);
	}
	@Test
	public void when0NumbersAreUsedThenMethodWillReturn0(){
		Assert.assertEquals(0, Calculator.add(""));
	}
	@Test (expected = RuntimeException.class)
	public void whenNonNumberIsUsedThenExceptionIsThrown(){
		Calculator.add("1,X");
	}
	@Test
	public void when2NumbersAreUsedThenMethodWillReturnSum(){
		int num1 = 0;
		
		for (int i = 0; i < 10000; i++){
			String numbersAsString = Integer.toString(num1) + "," + Integer.toString(i);
			Assert.assertEquals(i + num1, Calculator.add(numbersAsString));
			num1++;
		}
	}
	@Test
	public void when1NumberIsUsedThenMethodWillReturnThatNumber(){
		for (int i = 0; i < 10000; i++){
			Assert.assertEquals(i, Calculator.add(Integer.toString(i)));
		}
	}
	@Test
	public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
	    Assert.assertEquals(3+6+15, Calculator.add("3,6n15"));
	}

	//Requirement 5
	@Test
	public final void whenUserInputsNewDelimiterThenThatDelimiterIsUsed(){
		Assert.assertEquals(3+6+15, Calculator.add("//;n3,6n15"));
	}
	

}
