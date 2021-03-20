package by.darashuk.training.parser;

import by.darashuk.training.composite.api.IComposite;
import by.darashuk.training.composite.TextComposite;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import static by.darashuk.training.enums.ComponentType.PARAGRAPH;
import static by.darashuk.training.constants.TextConstants.PARAGRAPHS_SEPARATOR;

public class Text extends DataParser {

    private final static Logger logger = Logger.getLogger(Text.class);

    public Text(DataParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parseText(IComposite component, String input) {
        if (component == null || StringUtils.isEmpty(input)) {
            logger.info("IN parseText() IN Text: We got a problem : component==null||StringUtils.isEmpty(input) !");
        } else {
            logger.info("IN parseText() Text : process parsing was start...");

            String[] paragraphs = input.trim().split(PARAGRAPHS_SEPARATOR);
            for (String currentString : paragraphs) {
                TextComposite currentComposite = new TextComposite(PARAGRAPH);
                component.add(currentComposite);
                this.getNext().parseText(currentComposite, currentString);
            }
        }
    }
}