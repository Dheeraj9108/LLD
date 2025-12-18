package FoodDeliverySystemLLD.stratergy.agent;

import java.util.List;
import java.util.Optional;

import FoodDeliverySystemLLD.entities.DeliveryAgent;
import FoodDeliverySystemLLD.entities.Order;

public interface AgentStrategry {
    Optional<DeliveryAgent> find(Order order,List<DeliveryAgent> agent);
}
