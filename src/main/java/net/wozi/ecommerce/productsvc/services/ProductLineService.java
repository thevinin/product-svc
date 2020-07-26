package net.wozi.ecommerce.productsvc.services;

import net.wozi.ecommerce.productsvc.entities.Product;
import net.wozi.ecommerce.productsvc.entities.ProductLine;

import net.wozi.ecommerce.productsvc.repositories.ProductLineRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductLineService {
    private final ProductLineRepository productLineRepository;

    public ProductLineService(ProductLineRepository productLineRepository){
        this.productLineRepository = productLineRepository;
    }

    public ProductLine findProductLine(String productID){
        // for now simply lookup.  Later lookup product line from DB
        ProductLine productLine;
        switch (productID){
            case "H-123" : {
                productLine = new ProductLine("Saddles");
                break;
            }
            case "H-234" : {
                productLine = new ProductLine("Tack");
                break;
            }
            case "H-754" : {
                productLine = new ProductLine("Grooming Supplies");
                break;
            }
            case "H-456" : {
                productLine = new ProductLine("Blankets");
                break;
            }
            case "H-945" : {
                productLine = new ProductLine("Other Horse Accessories");
                break;
            }
            case "R-234" : {
                productLine = new ProductLine("Helmets");
                productLine.setProducts(getHelmets());
                break;
            }
            case "R-733" : {
                productLine = new ProductLine("Footwear");
                break;
            }
            case "R-537":{
                productLine = new ProductLine("Boots and Chaps");
                break;
            }
            case "R-285":{
                productLine = new ProductLine("Breeches");
                break;
            }
            case "R-034": {
                productLine = new ProductLine("Shirts and Jackets");
                break;
            }
            case "R-174": {
                productLine = new ProductLine("Other Rider Accessories");
                break;
            }
            case "G-453":{
                productLine = new ProductLine("Gifts and Decor");
                break;
            }
            default: {
                productLine = null;
            }
        }
        return productLine;
    }

    public Product findProductByName(String name){
        return null;
    }

    private List<Product> getHelmets(){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Samshield ShadowMat Helmet", "Samshield", BigDecimal.valueOf(499.99), "/img/helmets/SamsheildHelmet_500x500.jpg"));
        products.add(new Product("GPA Speed Air Helmet", "GPA", BigDecimal.valueOf(659.95), "/img/helmets/GPAhelmetspeedair500x500.jpg"));
        products.add(new Product("Charles Owen AYR8 Helmet", "Charles Owen", BigDecimal.valueOf(459.95), "/img/helmets/charlesowenhelmet_500x500.jpg"));

        return products;
    }
}
