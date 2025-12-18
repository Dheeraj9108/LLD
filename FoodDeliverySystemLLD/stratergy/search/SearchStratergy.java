package FoodDeliverySystemLLD.stratergy.search;

import java.util.List;

import FoodDeliverySystemLLD.entities.Restaurant;

public interface SearchStratergy {
    List<Restaurant> search(List<Restaurant> restaurants);
}
