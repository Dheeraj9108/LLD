package SplitwiseLLD.stratergy;

import java.util.ArrayList;
import java.util.List;

import SplitwiseLLD.entities.Split;
import SplitwiseLLD.entities.User;

public class EqualStartergy implements SplitStrategry {

    @Override
    public List<Split> calculate(List<User> users, List<Double> amounts, double amount) {
        List<Split> splits = new ArrayList<>();
        double amt = amount/users.size();
        for(int i = 0;i< users.size();i++){
            splits.add(new Split(users.get(i), amt));
        }
        return splits;
    }

}
