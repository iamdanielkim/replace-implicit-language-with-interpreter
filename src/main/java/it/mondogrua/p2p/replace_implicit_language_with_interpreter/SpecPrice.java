package it.mondogrua.p2p.replace_implicit_language_with_interpreter;

public class SpecPrice implements Spec {

    private float _priceLimit;

    public SpecPrice(float priceLimit) {
        _priceLimit = priceLimit;
    }

    public float getPriceLimit() {
        return _priceLimit;
    }

    /* (non-Javadoc)
     * @see it.mondogrua.p2p.replace_implicit_language_with_interpreter.pec#isSatisfiedBy(it.mondogrua.p2p.replace_implicit_language_with_interpreter.Product)
     */
    public boolean isSatisfiedBy(Product product) {
        return product.getPrice() == getPriceLimit();
    }

}
