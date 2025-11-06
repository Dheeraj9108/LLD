package OnlineShoppingSystemLLD.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import OnlineShoppingSystemLLD.entities.Product;
import OnlineShoppingSystemLLD.enums.ProductCategory;

public class SearchService {
    private Map<String,Product> products = new HashMap<>();
    
    public SearchService(Map<String,Product>products){
        this.products = products;
    }

    public List<Product> searchByName(String name){
        return products.values().stream().filter(product->product.getName().contains(name)).collect(Collectors.toList());
    }

    public List<Product> searchByCategory(ProductCategory category){
        return products.values().stream().filter(product->product.getCategory() == category).collect(Collectors.toList());
    }
}
