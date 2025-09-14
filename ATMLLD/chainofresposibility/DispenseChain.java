package ATMLLD.chainofresposibility;

public interface DispenseChain {
    public void setNextChain(DispenseChain chain);
    public void dispenseCash(int amount);
    public boolean canDispense(int amount);
}
