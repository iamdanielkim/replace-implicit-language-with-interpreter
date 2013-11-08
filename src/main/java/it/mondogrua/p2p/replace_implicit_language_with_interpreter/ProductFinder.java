package it.mondogrua.p2p.replace_implicit_language_with_interpreter;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ProductFinder {

    private final ProductRepository productRepository;

    public ProductFinder(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> byColor(Color colorOfProductToFind) {
        SpecColor spec = new SpecColor(colorOfProductToFind);
        List<Product> foundProducts = new ArrayList<Product>();
        for (Product product: productRepository) {
            if (spec.isSatisfiedBy(product)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public List<Product> byPrice(float priceLimit) {
        Spec spec = new SpecPrice(priceLimit);
        List<Product> foundProducts = new ArrayList<Product>();
        for (Product product : productRepository) {
            if (spec.isSatisfiedBy(product)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public List<Product> byColorSizeAndBelowPrice(Color color, ProductSize size,
            float price) {
        SpecColor specColor = new SpecColor(color);
        SpecSize specSize = new SpecSize(size);
        SpecBelowPrice specBelowPrice = new SpecBelowPrice(price);
        List<Product> foundProducts = new ArrayList<Product>();
        for (Product product : productRepository) {
            if (specColor.isSatisfiedBy(product)
                    && specSize.isSatisfiedBy(product)
                    && product.getPrice() < specBelowPrice.getPrice()) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public List<Product> belowPriceAvoidingAColor(float price, Color color) {
        List<Product> foundProducts = new ArrayList<Product>();
        for (Product product : productRepository) {
            if (product.getPrice() < price && product.getColor() != color) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

}
