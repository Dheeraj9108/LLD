package FoodDeliverySystemLLD.stratergy.search;

import java.util.List;
import java.util.stream.Collectors;

import FoodDeliverySystemLLD.entities.Restaurant;

public class ByMenuKeyword implements SearchStratergy {

    private String key;

    public ByMenuKeyword(String key) {
        this.key = key;
    }

    @Override
    public List<Restaurant> search(List<Restaurant> restaurants) {
        return restaurants.stream()
                .filter(r -> r.getMenu()
                        .getItems()
                        .values()
                        .stream()
                        .anyMatch(item -> item.getName().toLowerCase().contains(key.toLowerCase())))
                .collect(Collectors.toList());
    }

}
