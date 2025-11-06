package OnlineShoppingSystemLLD.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import OnlineShoppingSystemLLD.entities.Customer;
import OnlineShoppingSystemLLD.entities.Order;
import OnlineShoppingSystemLLD.entities.OrderItem;

public class OrderService {

    private InventoryService inventoryService;

    public OrderService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public Order createOrder(Customer customer){
        List<OrderItem> items = new ArrayList<>();
        customer.getCart().getMap().values().stream().forEach(product->{
            items.add(new OrderItem(product.getProduct().getId(), 
            product.getProduct().getName(),
            product.getProduct().getPrice(), product.getQty()));
        });
        inventoryService.updateStock(items);
        return new Order(customer, items, LocalDateTime.now(), customer.getCart().getTotalPrice());
    }
}
