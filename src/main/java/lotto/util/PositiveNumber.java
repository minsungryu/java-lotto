package lotto.util;

public class PositiveNumber extends Number {

    private int number;

    public PositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public PositiveNumber(String input) {
        this(Integer.parseInt(input));
    }

    @Override
    public int intValue() {
        return this.number;
    }

    @Override
    public long longValue() {
        return this.number;
    }

    @Override
    public float floatValue() {
        return this.number;
    }

    @Override
    public double doubleValue() {
        return this.number;
    }

}
