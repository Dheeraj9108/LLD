package OnlineShoppingSystemLLD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import OnlineShoppingSystemLLD.entities.Address;
import OnlineShoppingSystemLLD.entities.Cart;
import OnlineShoppingSystemLLD.entities.Customer;
import OnlineShoppingSystemLLD.entities.Order;
import OnlineShoppingSystemLLD.entities.Product;
import OnlineShoppingSystemLLD.service.InventoryService;
import OnlineShoppingSystemLLD.service.OrderService;
import OnlineShoppingSystemLLD.service.SearchService;
import OnlineShoppingSystemLLD.stratergy.PaymentStratergy;

public class OnlineShoppingSystemService {
    public static OnlineShoppingSystemService INSTANCE;
    private final Map<String, Order> orders = new HashMap<>();
    private final Map<String, Customer> customers = new HashMap<>();
    private final Map<String, Product> products = new HashMap<>();

    private SearchService searchService = new SearchService(products);
    private InventoryService inventoryService = new InventoryService();
    private OrderService orderService = new OrderService(inventoryService);

    private OnlineShoppingSystemService() {

    }

    public static OnlineShoppingSystemService getInstance() {
        if (INSTANCE == null) {
            synchronized (OnlineShoppingSystemService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new OnlineShoppingSystemService();
                }
            }
        }
        return INSTANCE;
    }

    public void addProduct(Product product, int qty) {
        products.put(product.getId(), product);
        inventoryService.addStock(product,qty);
    }

    public Customer registerCustomer(String id, String name, String email, Address address ){
        Customer c = new Customer(id, name, email, address);
        customers.put(c.getId(),c);
        return c;
    }

    public List<Product> serachByName(String name){
        return searchService.searchByName(name);
    }

    public Cart getCustomerCart(String customerId){
        return customers.get(customerId).getCart();
    }

    public void addToCart(String customerId, String productId, int qty){
        Customer c = customers.get(customerId);
        Product p = products.get(productId);
        c.getCart().addItem(p, qty);
    }

    public Order placeOrder(String customerId, PaymentStratergy stratergy){
        Customer c = customers.get(customerId);

        System.out.printf("placing order for %s\n",c.getName());
        
        stratergy.pay(c.getCart().getTotalPrice());
        
        System.out.printf("payment done \n");

        Order order = orderService.createOrder(c);

        orders.put(order.getId(), order);
        
        c.getCart().getMap().clear();

        return order;
    }
}
