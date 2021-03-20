package by.darashuk.training.app;

import by.darashuk.training.action.TextAction;
import by.darashuk.training.parser.*;
import by.darashuk.training.composite.TextComposite;
import by.darashuk.training.reader.TextReader;
import org.apache.log4j.Logger;

import static by.darashuk.training.enums.ComponentType.TEXT;
import static by.darashuk.training.constants.TextConstants.FILE_PATH;
import static by.darashuk.training.constants.TextConstants.WORD_LENGTH;

/**
 * 12. Remove from the text all words of a given length beginning with a consonant letter.
 */
public class App {

    private final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("IN main() : program start...");

        String input = new TextReader().readFromFile(FILE_PATH);

        DataParser wordParser = new Word();
        DataParser lexemeParser = new Lexeme(wordParser);
        DataParser sentenceParser = new Sentence(lexemeParser);
        DataParser paragraphParser = new Paragraph(sentenceParser);
        DataParser textParser = new Text(paragraphParser);
        TextComposite mainComposite = new TextComposite(TEXT);
        textParser.parseText(mainComposite, input);

        new TextAction().deleteSomeWords(mainComposite,WORD_LENGTH);
    }
}