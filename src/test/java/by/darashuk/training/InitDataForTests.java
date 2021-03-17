package by.darashuk.training;
/**
 The Class to initializing all data for tests.
 */
public class InitDataForTests {

	public String getTextForReadingTest() {
		return  "When an overloaded method is invoked, Java uses the type and number of\n" +
				" arguments as its guide to determine which version of the overloaded method to\n" +
				" actually call. Thus, overloaded methods must differ in the type and number\n" +
				" of their parameters.";
	}

	public String getRemovingSomeWord() {
		return "When " + "an " + "overloaded " +"method "+ "is " + "invoked " + "Java "
				+ "uses " + "type " + "and " + "number " + "of "
				+ "arguments " + "as " + "its " + "guide " + "to " + "determine "
				+ "which " + "version " + "of " + "overloaded "
				+ "method " + "to " + "actually " + "call"
				+ "\nThus " + "overloaded "
				+ "methods " + "must " + "differ " + "in " + "type " + "and " + "number "
				+ "of " + "their " + "parameters ";
	}
}
