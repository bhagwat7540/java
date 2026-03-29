package vendingmachine.entities;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> productMap;
    private final Map<String, Integer> stockMap;

    public Inventory() {
        this.productMap = new HashMap<>();
        this.stockMap = new HashMap<>();
    }

    public void addProduct(String code, Product product, int quantity) {
        productMap.put(code, product);
        stockMap.put(code, stockMap.getOrDefault(code, 0)+quantity);
    }

    public boolean isProductAvailable(String code) {
        return stockMap.getOrDefault(code, 0) > 0;
    }

    public Product getProduct(String code) {
        return productMap.get(code);
    }

    public void reduceStock(String code) {
        stockMap.put(code, stockMap.get(code)-1);
    }
}
