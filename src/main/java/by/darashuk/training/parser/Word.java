package by.darashuk.training.parser;

import by.darashuk.training.composite.Symbol;
import by.darashuk.training.composite.api.IComposite;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import static by.darashuk.training.composite.ComponentType.LETTER;

public class Word extends DataParser {

    private final static Logger logger = Logger.getLogger(Word.class);

    @Override
    public void parseText(IComposite component, String input) {
        if (component == null || StringUtils.isEmpty(input)) {
            logger.info("IN parseText() IN Word: We got a problem : component==null||StringUtils.isEmpty(input) !");
        } else {

            char[] characters = input.toCharArray();
            for (char ch : characters) {
                component.add(new Symbol(ch, LETTER));
            }
        }
    }
}