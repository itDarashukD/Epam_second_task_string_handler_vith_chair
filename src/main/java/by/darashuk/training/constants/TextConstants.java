package by.darashuk.training.constants;

public class TextConstants {
    //separate constants
    public static final String PARAGRAPHS_SEPARATOR = "\\p{Blank}{3}";
    public static final String LEXEMES_SEPARATOR = "\\p{Blank}";
    public static final String SENTENCES_SEPARATOR = "([^\\.{3}!?\\.]+[\\.{3}!?\\.])";
    public static final String SPACE_SEPARATOR = " ";
    public static final String LINES_SEPARATOR = "\n\r";
    public static final String WITHOUT_PUNCTUATION = "\\p{Alnum}";
    public static final String PUNCTUATION = "\\p{Punct}";

    //text constants
    public static final int WORD_LENGTH = 3;
    public static final String WORD_STARTING_WITH_CONSONANT = "^(?i:[qwrtplkjhgfdszxcvbnm]).*";
    public static final String REGEX_BLANKS = "\\p{Blank}";
    public static final String FILE_PATH = "src/main/resources/MainText.txt";

    //test constants
    public static final String STRING_FOR_TEST = "src/test/resources/ForTest.txt";
}
