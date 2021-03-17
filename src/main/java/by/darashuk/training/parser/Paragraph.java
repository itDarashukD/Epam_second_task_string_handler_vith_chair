package by.darashuk.training.parser;

import by.darashuk.training.composite.api.IComposite;
import by.darashuk.training.composite.TextComposite;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.darashuk.training.composite.ComponentType.SENTENCE;
import static by.darashuk.training.parser.Separator.SENTENCES_SEPARATOR;

public class Paragraph extends DataParser {

    private final static Logger logger = Logger.getLogger(Paragraph.class);

    public Paragraph(DataParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parseText(IComposite component, String input) {
        if (component == null || StringUtils.isEmpty(input)) {
            logger.info("IN parseText() IN Paragraph: We got a problem : component==null||StringUtils.isEmpty(input) !");
        } else {
            logger.info("IN parseText() Paragraph : process parsing was start...");

            Pattern pattern = Pattern.compile(SENTENCES_SEPARATOR);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                TextComposite currentComposite = new TextComposite(SENTENCE);
                component.add(currentComposite);
                this.getNext().parseText(currentComposite, matcher.group(1)); //the sentence itself without a punctuation mark
            }
        }
    }
}