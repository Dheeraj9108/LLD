package SnakeAndLadderLLD.entity;

public class Dice {
    private int minValue;
    private int maxValue;
    public Dice(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
    public int getMinValue() {
        return minValue;
    }
    public int getMaxValue() {
        return maxValue;
    }

    public int roll(){
        return (int) ((Math.random() * maxValue - minValue + 1) + minValue);
    }
}
