package backtester;

public class Main {
    public static void main(String[] args) {
        String dataPath = "data/market_data.csv";

        // Cargar datos del mercado
        MarketDataLoader loader = new MarketDataLoader();
        var marketData = loader.loadMarketData(dataPath);

        // Configurar estrategia
        Strategy strategy = new Strategy() {
            @Override
            public boolean shouldBuy(double currentPrice, double movingAverage) {
                return currentPrice > movingAverage;
            }

            @Override
            public boolean shouldSell(double currentPrice, double movingAverage) {
                return currentPrice < movingAverage;
            }
        };

        // Evaluar estrategia
        StrategyEvaluator evaluator = new StrategyEvaluator(strategy);
        var trades = evaluator.evaluateStrategy(marketData);

        // Calcular métricas
        MetricsCalculator calculator = new MetricsCalculator();
        var metrics = calculator.calculateMetrics(trades);

        // Mostrar resultados
        System.out.println("Backtest Results:");
        System.out.println(metrics);
    }
}
