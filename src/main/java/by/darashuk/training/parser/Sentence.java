package by.darashuk.training.parser;

import by.darashuk.training.composite.api.IComposite;
import by.darashuk.training.composite.TextComposite;
import by.darashuk.training.constants.TextConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import static by.darashuk.training.enums.ComponentType.LEXEME;

public class Sentence extends DataParser {

    private final static Logger logger = Logger.getLogger(Sentence.class);

    public Sentence(DataParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parseText(IComposite component, String input) {
        if (component == null || StringUtils.isEmpty(input)) {
            logger.info("IN parseText() IN Sentence: We got a problem : component==null||StringUtils.isEmpty(input) !");
        } else {
            logger.info("IN parseText() Sentence : process parsing was start...");

            String[] lexemes = input.trim().split(TextConstants.LEXEMES_SEPARATOR);
            for (String currentString : lexemes) {
                TextComposite currentComposite = new TextComposite(LEXEME);
                component.add(currentComposite);
                this.getNext().parseText(currentComposite, currentString);
            }
        }
    }
}