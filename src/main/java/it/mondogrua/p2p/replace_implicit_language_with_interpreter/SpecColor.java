package it.mondogrua.p2p.replace_implicit_language_with_interpreter;

import java.awt.Color;

public class SpecColor implements Spec {

    private Color _color;

    public SpecColor(Color colorOfProductToFind) {
        _color = colorOfProductToFind;
    }

    public Color getColor() {
        return _color;
    }

    public boolean isSatisfiedBy(Product product) {
        return product.getColor().equals(getColor());
    }





}
