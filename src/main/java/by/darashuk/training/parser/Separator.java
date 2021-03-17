package by.darashuk.training.parser;

public class Separator {

    public static final String PARAGRAPHS_SEPARATOR = "\\p{Blank}{3}";
    public static final String LEXEMES_SEPARATOR = "\\p{Blank}+";
    public static final String SENTENCES_SEPARATOR = "([^\\.{3}!?\\.]+[\\.{3}!?\\.])";
    public static final String SPACE_SEPARATOR = " ";
    public static final String LINES_SEPARATOR = "\n\r";
    public static final String WITHOUT_PUNCTUATION = "\\p{Alnum}";
    public static final String PUNCTUATION = "\\p{Punct}";

}
