package by.darashuk.training.reader;

import by.darashuk.training.InitDataForTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static by.darashuk.training.constants.TextConstants.STRING_FOR_TEST;
import static org.testng.Assert.assertEquals;

public class TextReaderTest {

    private TextReader reader;

    @BeforeClass
    public void setUp() {
        reader = new TextReader();
    }

    @Test
    public void testReadFile() {
        String actual = reader.readFromFile(STRING_FOR_TEST);
        System.out.println(actual.trim() + "\n");
        String expected = new InitDataForTests().getTextForReadingTest();
        System.out.println(expected);
        assertEquals(actual, expected);
    }
}