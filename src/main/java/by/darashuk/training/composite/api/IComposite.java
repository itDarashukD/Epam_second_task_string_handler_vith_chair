package by.darashuk.training.composite.api;

import java.util.ArrayList;
import java.util.List;

public interface IComposite {

    String write();

    default void add(IComposite component) {}

    default void remove(IComposite component) {}

    default  List<IComposite>  getTextComponents() {
        return new ArrayList<>();
    }
}
