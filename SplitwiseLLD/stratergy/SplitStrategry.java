package SplitwiseLLD.stratergy;

import java.util.List;

import SplitwiseLLD.entities.Split;
import SplitwiseLLD.entities.User;

public interface SplitStrategry {
    public List<Split> calculate(List<User> users, List<Double> amounts, double amount);
}
