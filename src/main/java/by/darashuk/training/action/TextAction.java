package by.darashuk.training.action;

import by.darashuk.training.composite.api.IComposite;
import by.darashuk.training.composite.TextComposite;
import org.apache.log4j.Logger;

import java.util.*;

import static by.darashuk.training.constants.TextConstants.WORD_STARTING_WITH_CONSONANT;
import static by.darashuk.training.constants.TextConstants.PUNCTUATION;
import static by.darashuk.training.constants.TextConstants.REGEX_BLANKS;

public class TextAction {

    private final static Logger logger = Logger.getLogger(TextAction.class);
    private final StringBuilder withoutWords = new StringBuilder();
    private final StringBuilder allText = new StringBuilder();

    public String deleteSomeWords(TextComposite mainComposite, int WORD_LENGTH) {
        if (mainComposite == null) {
            logger.info("IN deleteSomeWords() : We got a problem : mainComposite == null !");
        } else {
            logger.info("IN deleteSomeWords() : deleting start...");

            getAllText(mainComposite);

            ArrayList<String> arrayOfWords = new ArrayList<>(
                    Arrays.asList(allText.toString().replaceAll(PUNCTUATION, "")
                            .split(REGEX_BLANKS)));

            arrayOfWords.removeIf(element ->
                    (element.length() == WORD_LENGTH)
                            && (element.matches(WORD_STARTING_WITH_CONSONANT)));

            for (String word : arrayOfWords) {
                withoutWords.append(word).append(" ");
            }
        }
        return withoutWords.toString();
    }

    public void getAllText(TextComposite mainComposite) {
        logger.info("IN getAllText() : getting all text start...");

        for (int i = 0; i < mainComposite.getTextComponents().size(); i++) {
            IComposite composite = mainComposite.getTextComponents().get(i);
            String recoveredText = composite.write();
            allText.append(recoveredText);
        }
    }
}