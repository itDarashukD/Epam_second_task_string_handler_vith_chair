package by.darashuk.training.composite;

import by.darashuk.training.action.TextAction;
import by.darashuk.training.composite.api.IComposite;

import java.util.ArrayList;
import java.util.List;

import static by.darashuk.training.parser.Separator.*;

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

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }
}
