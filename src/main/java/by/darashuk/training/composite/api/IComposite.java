package by.darashuk.training.composite.api;

import by.darashuk.training.composite.ComponentType;

import java.util.List;

public interface IComposite {
    String write();

    default void add(IComposite component) {

    }
    default void remove(IComposite component) {

    }
    default  List<IComposite>  getTextComponents() {
        return null;
    }
    default ComponentType getComponentType(){
        return null;
    }
}
