package by.darashuk.training.action;

import by.darashuk.training.InitDataForTests;
import by.darashuk.training.composite.api.IComposite;
import by.darashuk.training.parser.*;
import by.darashuk.training.composite.TextComposite;
import by.darashuk.training.reader.TextReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

import static by.darashuk.training.composite.ComponentType.TEXT;
import static org.testng.Assert.assertEquals;

public class DeleteSomeWordTest {

    private final String STRING_FOR_TEST = "src/test/resources/ForTest.txt";
    private TextReader reader;
    private TextComposite mainComposite;

    @BeforeClass
    public void setUp() {
        reader = new TextReader();
        DataParser wordParser = new Word();
        DataParser lexemeParser = new Lexeme(wordParser);
        DataParser sentenceParser = new Sentence(lexemeParser);
        DataParser paragraphParser = new Paragraph(sentenceParser);
        DataParser textParser = new Text(paragraphParser);

        String input = reader.readFromFile(STRING_FOR_TEST);

        mainComposite = new TextComposite(TEXT);
        textParser.parseText(mainComposite, input);

    }

    @Test
    public void testDeleteSomeWords() {

        String actualValue = new TextAction().deleteSomeWords(mainComposite);
        System.out.println(actualValue);

        String expectedValue = new InitDataForTests().getRemovingSomeWord();
        System.out.println(expectedValue);
        assertEquals(actualValue, expectedValue);
    }
}