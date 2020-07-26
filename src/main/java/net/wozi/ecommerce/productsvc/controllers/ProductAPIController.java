package net.wozi.ecommerce.productsvc.controllers;

import net.wozi.ecommerce.productsvc.entities.ProductLine;
import net.wozi.ecommerce.productsvc.services.HeroService;
import net.wozi.ecommerce.productsvc.services.MessageService;
import net.wozi.ecommerce.productsvc.services.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductAPIController {

    @Autowired
    MessageService messageService;

    @Autowired
    HeroService heroService;

    @Autowired
    ProductLineService productLine;

    @GetMapping("/productLine/info")
    public String getInfo(){

        return "{ \"id\":\"123-ABC\", " + "\"name\":\"Crackberry\", \"color\":\"black\", \"price\":123.45, " +
                "\"sizes\":[\"s\", \"m\", \"l\", \"xl\"], \"styles\":[\"small\", \"med\", \"large\"] }";
    }

    @GetMapping("/{productLineID}")
    public ProductLine getProductLine(@PathVariable String productLineID){
        return productLine.findProductLine(productLineID);
    }

    @GetMapping("/heroes")
    public String getHeroes(){
        return heroService.getHeroes();
    }

    @GetMapping("/heroes/{heroID}")
    public String getHero(@PathVariable int heroID){
        return heroService.getAHeroByID(heroID);
    }

    @GetMapping("/messages")
    public String getMessage(){
        return messageService.getMessage();
    }
}
