package by.darashuk.training.reader;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class TextReader {

    private final static Logger logger = Logger.getLogger(TextReader.class);

    public String readFromFile(String pathToFile) {

        logger.info("IN readFromFile() : File are reading...");
        StringBuilder builder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {
            Stream<String> stream = bufferedReader.lines();
            stream.forEach(o -> builder.append(o).append("\n"));
        } catch (IOException e) {
            logger.error("Wrong filepath: " + pathToFile);
        }
        return builder.toString().trim();
    }
}