package FoodDeliverySystemLLD.stratergy.agent;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import FoodDeliverySystemLLD.entities.Address;
import FoodDeliverySystemLLD.entities.DeliveryAgent;
import FoodDeliverySystemLLD.entities.Order;

public class Nearest implements AgentStrategry{

    @Override
    public Optional<DeliveryAgent> find(Order order,List<DeliveryAgent> agents) {
        Address cAddress = order.getCustomer().getAddress();
        Address rAddress = order.getRestaurant().getAddress();
        return agents
                .stream()
                .filter(a->a.isAvailable())
                .min(Comparator.comparingDouble(e->calculate(cAddress,rAddress,e.getAddress())));
    }

    private Double calculate(Address cAdd, Address rAdd, Address agentAdd){
        Double agentDist = agentAdd.distanceTo(rAdd);
        Double cDist = cAdd.distanceTo(rAdd);
        return agentDist + cDist;
    }
    
}
