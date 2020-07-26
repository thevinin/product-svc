package net.wozi.ecommerce.productsvc.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    @OneToMany
    List<Product> products = new ArrayList<>();

    public ProductLine(){ ; }

    public ProductLine(String name) {
        this.name = name;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public int forRows(int withNumberOfColumns){
        double result = (double)products.size()/withNumberOfColumns;
        return (int)( Math.ceil(result) );
    }

    /**
     * Provides the next row of products in columns of maxColumns.  Requesting nextRow on empty product list
     * or requesting next row beyond number of products results in empty row.
     * @param currentRow - identifies index of current row, -1 indicates no current row, starting row
     * @param maxColumns - maximum number of columns in row
     * @return List<Product> - a row of product line, containing number of items for max # of columns
     */
    public List<Product> getNextRow(int currentRow, int maxColumns){
        List<Product> nextRow = new ArrayList<>();
        if (currentRow == -1)
            nextRow = products.subList(0, limitColumns(maxColumns, products.size()));
        else if (!products.isEmpty() && validRowRequest(currentRow + maxColumns, products.size()))
            nextRow = products.subList(currentRow+maxColumns, limitColumns( (currentRow+maxColumns)+(maxColumns-1), products.size()));
        return nextRow;
    }

    /**
     * Limits number of columns to limit, if value > limit return limit otherwise return value
     * @return limit
     */
    private int limitColumns(int value, int limit){
        return Math.min(value, limit);
    }

    private boolean validRowRequest(int rowRequested, int numberOfProducts){
        return rowRequested < numberOfProducts;
    }
}
