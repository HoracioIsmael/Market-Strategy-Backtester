package backtester;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MarketDataLoader {
    public List<Double> loadMarketData(String filePath) {
        List<Double> marketData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                marketData.add(Double.parseDouble(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marketData;
    }
}

