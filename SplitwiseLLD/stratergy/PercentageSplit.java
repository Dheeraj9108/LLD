package SplitwiseLLD.stratergy;

import java.util.ArrayList;
import java.util.List;

import SplitwiseLLD.entities.Split;
import SplitwiseLLD.entities.User;

public class PercentageSplit implements SplitStrategry{

    @Override
    public List<Split> calculate(List<User> users, List<Double> amounts, double amount) {
        List<Split> splits = new ArrayList<>();
        for(int i = 0;i< users.size();i++){
            double amt = (amount * amounts.get(i))/100.00;
            splits.add(new Split(users.get(i), amt));
        }
        return splits;
    }
    
}
