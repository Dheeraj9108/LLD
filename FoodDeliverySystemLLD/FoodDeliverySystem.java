package FoodDeliverySystemLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import FoodDeliverySystemLLD.entities.Address;
import FoodDeliverySystemLLD.entities.Customer;
import FoodDeliverySystemLLD.entities.DeliveryAgent;
import FoodDeliverySystemLLD.entities.Menu;
import FoodDeliverySystemLLD.entities.Order;
import FoodDeliverySystemLLD.entities.OrderItem;
import FoodDeliverySystemLLD.entities.Restaurant;
import FoodDeliverySystemLLD.enums.OrderStatus;
import FoodDeliverySystemLLD.stratergy.agent.AgentStrategry;
import FoodDeliverySystemLLD.stratergy.search.SearchStratergy;

public class FoodDeliverySystem {
    private static FoodDeliverySystem INSTANCE;
    private Map<String, Customer> customers;
    private Map<String,Restaurant> restaurants;
    private Map<String,DeliveryAgent> agents;
    private Map<String,Order> orders;
    private AgentStrategry strategry;

    private FoodDeliverySystem(){
        customers = new HashMap<>();
        restaurants = new HashMap<>();
        agents = new HashMap<>();
        orders = new HashMap<>(); 
    }

    public static FoodDeliverySystem getInstance(){
        if(INSTANCE == null){
            synchronized(FoodDeliverySystem.class){
                if(INSTANCE == null){
                    INSTANCE = new FoodDeliverySystem();
                }
            }
        }
        return INSTANCE;
    }

    public Customer registerCustomer(String name, String phone, Address address){
        Customer c = new Customer(name, phone, address);
        customers.put(c.getId(), c);
        return c;
    }

    public Restaurant registerRestaurant(String name, Address address){
        Restaurant r = new Restaurant(name, address);
        restaurants.put(r.getId(), r);
        return r;
    }

    public DeliveryAgent registerAgent(String name, String phone, Address address){
        DeliveryAgent d = new DeliveryAgent(name, phone, address);
        agents.put(d.getId(), d);
        return d;
    }

    public Order placeOrder(String customerId, String restaurantId, List<OrderItem> items){
        Customer c = customers.get(customerId);
        Restaurant r = restaurants.get(restaurantId);

        Order o = new Order(c, r, items);
        orders.put(o.getId(), o);
        c.addOrderInHostory(o);
        System.out.printf("Order placed id %s",o.getId());
        return o;
    }

    public void updateOrderStatus(String orderId ,OrderStatus status){
        Order order = orders.get(orderId);
        order.setStatus(status);

        if(status == OrderStatus.REDY_TO_PICK){
            assignDeliveryAgent(order);
        }
    }

    public void setAgentStratergy(AgentStrategry strategry){
        this.strategry = strategry;
    }

    private void assignDeliveryAgent(Order order){
        strategry.find(order, new ArrayList<>(agents.values())).ifPresentOrElse(
            a->{
                System.out.printf("Agent found %s \n" , a.getName());
                order.assignAgent(a);
            }, ()-> System.out.println("No agent available"));
    }

    public List<Restaurant> searchRestaurants(List<SearchStratergy> stratergies){
        List<Restaurant> res = new ArrayList<>();

        for(SearchStratergy stratergy:stratergies){
            res.addAll(stratergy.search(new ArrayList<>(restaurants.values())));
        }
        return res;
    }

    public Menu getRestaurantMenu(String resId){
        return restaurants.get(resId).getMenu();
    }
}
