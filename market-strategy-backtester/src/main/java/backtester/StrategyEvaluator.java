package backtester;

import java.util.ArrayList;
import java.util.List;

public class StrategyEvaluator {
    private final Strategy strategy;

    public StrategyEvaluator(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Trade> evaluateStrategy(List<Double> marketData) {
        List<Trade> trades = new ArrayList<>();
        double movingAverage = 0;
        int window = 5; // Ventana para promedio móvil

        for (int i = 0; i < marketData.size(); i++) {
            double currentPrice = marketData.get(i);
            movingAverage = calculateMovingAverage(marketData, i, window);

            if (strategy.shouldBuy(currentPrice, movingAverage)) {
                trades.add(new Trade(i, "BUY", currentPrice));
            } else if (strategy.shouldSell(currentPrice, movingAverage)) {
                trades.add(new Trade(i, "SELL", currentPrice));
            }
        }
        return trades;
    }

    private double calculateMovingAverage(List<Double> data, int currentIndex, int window) {
        int start = Math.max(0, currentIndex - window + 1);
        int count = 0;
        double sum = 0;

        for (int i = start; i <= currentIndex; i++) {
            sum += data.get(i);
            count++;
        }
        return sum / count;
    }
}
