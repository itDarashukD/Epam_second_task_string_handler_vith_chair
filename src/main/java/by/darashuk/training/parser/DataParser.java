package by.darashuk.training.parser;

import by.darashuk.training.composite.api.IComposite;

public abstract class DataParser {
    private DataParser next;

    DataParser(){}

    DataParser(DataParser nextParser) {
        this.next = nextParser;
    }

    DataParser getNext() {
        return this.next;
    }

    public abstract void parseText(IComposite component, String input);
}
