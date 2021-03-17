package by.darashuk.training.parser;

import by.darashuk.training.action.TextAction;
import by.darashuk.training.composite.ComponentType;
import by.darashuk.training.composite.Symbol;
import by.darashuk.training.composite.api.IComposite;
import by.darashuk.training.composite.TextComposite;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Lexeme extends DataParser {

    private final static Logger logger = Logger.getLogger(Lexeme.class);

    public Lexeme(DataParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parseText(IComposite component, String input) {
        if (component == null || StringUtils.isEmpty(input)) {
            logger.info("IN parseText() IN Lexeme: We got a problem : component==null||StringUtils.isEmpty(input) !");
        } else {

            ArrayList<String> arrayOfWords = new ArrayList<>(
                    Arrays.asList(input
                            .replaceAll("\\p{Punct}", "")
                            .split("\\p{Blank}")));

            for (String stringWords : arrayOfWords
            ) {
                TextComposite current = new TextComposite(ComponentType.WORD);
                component.add(current);
                this.getNext().parseText(current, stringWords);
            }
            char[] charArray = input.toCharArray();
            for (char character : charArray
            ) {
                if (Pattern.matches(Separator.PUNCTUATION, String.valueOf(character))) {
                    component.add(new Symbol(character, ComponentType.SIGN));
                }
            }
        }
    }
}