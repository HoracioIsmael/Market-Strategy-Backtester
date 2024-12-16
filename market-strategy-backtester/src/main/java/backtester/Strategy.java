package backtester;

public interface Strategy {
    boolean shouldBuy(double currentPrice, double movingAverage);
    boolean shouldSell(double currentPrice, double movingAverage);
}
