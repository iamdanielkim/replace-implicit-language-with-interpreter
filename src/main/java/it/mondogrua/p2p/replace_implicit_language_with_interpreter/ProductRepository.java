package it.mondogrua.p2p.replace_implicit_language_with_interpreter;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class ProductRepository extends ArrayList<Product> {

    public boolean add(Product product) {
        return super.add(product);
    }

}
