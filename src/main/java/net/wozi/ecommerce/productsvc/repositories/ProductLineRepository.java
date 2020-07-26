package net.wozi.ecommerce.productsvc.repositories;

import net.wozi.ecommerce.productsvc.entities.ProductLine;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductLineRepository extends JpaRepository<ProductLine, Long> {

}
