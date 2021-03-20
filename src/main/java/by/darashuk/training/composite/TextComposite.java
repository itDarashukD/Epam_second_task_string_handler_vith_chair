package by.darashuk.training.composite;

import by.darashuk.training.composite.api.IComposite;
import by.darashuk.training.enums.ComponentType;

import java.util.ArrayList;
import java.util.List;

import static by.darashuk.training.constants.TextConstants.*;

public class TextComposite implements IComposite {

    private final List<IComposite> compositeList = new ArrayList<>();
    private final ComponentType componentType;
    private final StringBuilder stringBuilder = new StringBuilder();

    public TextComposite(ComponentType componentType) {
        this.componentType = componentType;
    }

    @Override
    public String write() {
        switch (componentType) {
            case PARAGRAPH:
                for (IComposite composite : compositeList) {
                    stringBuilder.append(composite.write()).append("\n");
                }
                break;
            case SENTENCE:
                for (IComposite composite : compositeList) {
                    stringBuilder.append(composite.write()).append(SPACE_SEPARATOR);
                }
                break;
            default:
                for (IComposite composite : compositeList) {
                    stringBuilder.append(composite.write());
                }
                break;
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public void add(IComposite component) {
        compositeList.add(component);
    }

    @Override
    public List<IComposite> getTextComponents() {
        return compositeList;
    }
}
