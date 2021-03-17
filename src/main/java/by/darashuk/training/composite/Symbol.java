package by.darashuk.training.composite;

import by.darashuk.training.composite.api.IComposite;

public class Symbol implements IComposite {
    private final Character character;
    private final ComponentType componentType;

    public Symbol(Character character, ComponentType componentType) {
        this.character = character;
        this.componentType = componentType;
    }

    @Override
    public String write() {
        return character.toString();
    }

}
