package backtester;

public class Trade {
    private final int day;
    private final String type;
    private final double price;

    public Trade(int day, String type, double price) {
        this.day = day;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "day=" + day +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
