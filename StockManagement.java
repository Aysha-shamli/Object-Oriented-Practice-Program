package oopsConcept;
import java.util.Scanner;
class Stock {
    String stockName;
    int numberOfShares;
    double sharePrice;
    public Stock(String stockName, int numberOfShares, double sharePrice) {
        this.stockName = stockName;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }
    public double calculateStockValue() {
        return numberOfShares * sharePrice;
    }
}
class StockPortfolio {
    Stock[] stocks;
    public StockPortfolio(int numberOfStocks) {
        stocks = new Stock[numberOfStocks];
    }
    public void addStock(int index, String stockName, int numberOfShares, double sharePrice) {
        stocks[index] = new Stock(stockName, numberOfShares, sharePrice);
    }
    public double calculateTotalPortfolioValue() {
        double totalValue = 0;
        for (Stock stock : stocks) {
            totalValue += stock.calculateStockValue();
        }
        return totalValue;
    }
    public void printStockReport() {
        System.out.println("Stock Report:");
        for (Stock stock : stocks) {
            System.out.println("\nStock: " + stock.stockName);
            System.out.println("Number of Shares: " + stock.numberOfShares);
            System.out.println("Share Price: $" + stock.sharePrice);
            System.out.println("Stock Value: $" + stock.calculateStockValue());

        }
        System.out.println("Total Portfolio Value: $" + calculateTotalPortfolioValue());
    }
}
public class StockManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of stocks: ");
        int numberOfStocks = scanner.nextInt();

        StockPortfolio stockPortfolio = new StockPortfolio(numberOfStocks);

        for (int i = 0; i < numberOfStocks; i++) {
            System.out.println("\nEnter details for Stock " + (i + 1) + ":");
            System.out.print("Enter Stock Name: ");
            String stockName = scanner.next();
            System.out.print("Enter Number of Shares: ");
            int numberOfShares = scanner.nextInt();
            System.out.print("Enter Share Price: $");
            double sharePrice = scanner.nextDouble();

            stockPortfolio.addStock(i, stockName, numberOfShares, sharePrice);
        }

        stockPortfolio.printStockReport();
    }
}
