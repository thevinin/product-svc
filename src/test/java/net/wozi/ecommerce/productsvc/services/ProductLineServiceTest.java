package net.wozi.ecommerce.productsvc.services;

import net.wozi.ecommerce.productsvc.entities.ProductLine;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
class ProductLineServiceTest {
    @Autowired
    ProductLineService productLineService;

    @Test
    public void testHelmetProductLine(){
        ProductLine products = productLineService.findProductLine("R-234");
        // Ensure that 3 helmet products are returned
        assertEquals(products.getProducts().size(), 3);
        // validate 3 products in list
        assertEquals(products.getProducts().get(0).getName(), "Samshield ShadowMat Helmet");
        assertEquals(products.getProducts().get(1).getName(), "GPA Speed Air Helmet");
        assertEquals(products.getProducts().get(2).getName(), "Charles Owen AYR8 Helmet");
    }

    @Test
    public void notValidProductLine(){
        ProductLine products = productLineService.findProductLine("Q-234");
        assertNull(products);
    }
}
