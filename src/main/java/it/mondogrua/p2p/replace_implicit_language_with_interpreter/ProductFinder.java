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
        List<Product> foundProducts = new ArrayList<Product>();
        for (Product product: productRepository) {
            if (product.getColor().equals(colorOfProductToFind)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public List<Product> byPrice(float priceLimit) {
        List<Product> foundProducts = new ArrayList<Product>();
        for (Product product : productRepository) {
            if (product.getPrice() == priceLimit) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public List<Product> byColorSizeAndBelowPrice(Color color, ProductSize size,
            float price) {
        List<Product> foundProducts = new ArrayList<Product>();
        for (Product product : productRepository) {
            if (product.getColor() == color 
                    && product.getSize() == size
                    && product.getPrice() < price) {
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
