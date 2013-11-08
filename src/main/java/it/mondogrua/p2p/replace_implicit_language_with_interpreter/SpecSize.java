package it.mondogrua.p2p.replace_implicit_language_with_interpreter;

public class SpecSize implements Spec {

    private ProductSize _size;

    public SpecSize(ProductSize size) {
        _size = size;
    }

    public ProductSize getSize() {
        return _size;
    }

    public boolean isSatisfiedBy(Product product) {
        return product.getSize() == getSize();
    }



}
