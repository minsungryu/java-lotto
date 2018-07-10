package lotto.util;

public class RateDouble extends Number {

    private double rate;

    public RateDouble(double rate) {
        this.rate = Double.parseDouble(String.format("%.1f", rate));
    }

    public RateDouble(String rate) {
        this(Double.parseDouble(rate));
    }

    @Override
    public int intValue() {
        return (int) rate;
    }

    @Override
    public long longValue() {
        return (long) rate;
    }

    @Override
    public float floatValue() {
        return (float) rate;
    }

    @Override
    public double doubleValue() {
        return rate;
    }

    @Override
    public String toString() {
        return String.format("%.1f", rate);
    }

}
