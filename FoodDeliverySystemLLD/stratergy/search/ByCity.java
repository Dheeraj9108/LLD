package FoodDeliverySystemLLD.stratergy.search;

import java.util.List;
import java.util.stream.Collectors;

import FoodDeliverySystemLLD.entities.Restaurant;

public class ByCity implements SearchStratergy{

    private String city;
    
    public ByCity(String city){
        this.city = city;
    }

    @Override
    public List<Restaurant> search(List<Restaurant> restaurants) {
        return restaurants.stream().filter(r->r.getAddress().getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
    }
    
}
