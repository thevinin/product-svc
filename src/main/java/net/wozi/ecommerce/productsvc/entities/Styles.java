package net.wozi.ecommerce.productsvc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Styles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String style;
}
