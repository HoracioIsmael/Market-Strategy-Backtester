package backtester;

import java.util.List;

public class MetricsCalculator {
    public String calculateMetrics(List<Trade> trades) {
        double totalProfit = 0;
        int tradeCount = trades.size();

        for (Trade trade : trades) {
            totalProfit += trade.type.equals("SELL") ? 10 : -10; // Simulación de ganancias/perdidas
        }

        return "Total Trades: " + tradeCount + "\n" +
               "Total Profit: " + totalProfit;
    }
}