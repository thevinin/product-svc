package net.wozi.ecommerce.productsvc.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long    id;
    String  name;
    String  vendor;
    String code; // will eventually use UPC
    BigDecimal salesPrice;
    BigDecimal discount;
    @OneToMany()
    List<Sizes> sizes;
    @OneToMany
    List<Colors> colors;
    @OneToMany
    List<Styles> styles;
    String imageURL;

    // default constructor - required for JPA
    public Product(){}

    public Product(String name, String vendor, BigDecimal salesPrice, String imageURL){
        this.name = name;
        this.vendor = vendor;
        this.salesPrice = salesPrice;
        this.imageURL = imageURL;
    }
}
