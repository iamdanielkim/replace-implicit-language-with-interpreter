package it.mondogrua.p2p.replace_implicit_language_with_interpreter;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ProductFinderTests {

    private ProductFinder finder;

    private Product fireTruck =
            new Product("f1234", "Fire Truck", Color.red, 8.95f, ProductSize.MEDIUM);

    private Product barbieClassic =
            new Product("b7654", "Baribie Classic", Color.yellow, 15.95f, ProductSize.SMALL);

    private Product frisbee =
            new Product("f4321", "Frisbee", Color.pink, 9.99f, ProductSize.LARGE);

    private Product baseball =
            new Product("b2343", "Baseball", Color.white, 8.95f, ProductSize.NOT_APLICABLE);

    private Product toyConvertible =
            new Product("p1112", "Toy Porche Convertible", Color.red, 230.00f, ProductSize.NOT_APLICABLE);

    @Before
    public void setup() {
        finder = new ProductFinder(createProductRepository());
    }

    private ProductRepository createProductRepository() {
        ProductRepository repository = new ProductRepository();
        repository.add(fireTruck);
        repository.add(barbieClassic);
        repository.add(frisbee);
        repository.add(baseball);
        repository.add(toyConvertible);
        return repository;
    }

    @Test
    public void testFindByColor() {
        List<Product> foundProducts = finder.byColor(Color.red);
        assertEquals("found 2 red products", 2, foundProducts.size());
        assertTrue("found fireTruck",  foundProducts.contains(fireTruck));
        assertTrue("found toy Porche Convertible", foundProducts.contains(toyConvertible));
    }

    @Test
    public void testFindByPrice() {
        List<Product> foundProducts = finder.byPrice(8.95f);
        assertEquals("Found products that cost $8.95", 2, foundProducts.size());
        for (Product product : foundProducts) {
            assertTrue(product.getPrice() == 8.95f);
        }
    }

    @Test
    public void testFindByColorSizeAndBelowPrice() {
        List<Product> foundProducts = finder.byColorSizeAndBelowPrice(Color.red, ProductSize.SMALL, 10.00f);
        assertEquals("found no small red products below $10.00", 0, foundProducts.size());
        foundProducts = finder.byColorSizeAndBelowPrice(Color.red, ProductSize.MEDIUM, 10.00f);
        assertEquals("found firetruck when looking for cheap medium red toys", fireTruck, foundProducts.get(0) );
    }
    
    @Test
    public void testFindBelowPriceAvoidingAColor() {
        List<Product> foundProducts = finder.belowPriceAvoidingAColor(9.00f, Color.white);
        assertEquals("found 1 non-white product < $9.00", 1, foundProducts.size() );
        assertTrue("found fireTruck", foundProducts.contains(fireTruck));
        foundProducts = finder.belowPriceAvoidingAColor(9.00f, Color.red);
        assertEquals("found one non red product", 1, foundProducts.size());
        assertTrue("found baseball", foundProducts.contains(baseball));
    }
    
    

}
