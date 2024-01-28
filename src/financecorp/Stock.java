package financecorp;

public class Stock extends Investment implements PortfolioValue{
    private int dividendYield;
    private int marketCapitalization;
    
    public Stock(String customerName, String investmentType, String symbol, String name, int quantity, int purchasePrice, int currentMarketValue, int dividendYield, int marketCapitalization) {
        super(customerName, investmentType, symbol, name, quantity, purchasePrice, currentMarketValue);
        this.dividendYield = dividendYield;
        this.marketCapitalization = marketCapitalization;
    } // end of paramterized constructor

    public int getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield(int dividendYield) {
        this.dividendYield = dividendYield;
    }

    public int getMarketCapitalization() {
        return marketCapitalization;
    }

    public void setMarketCapitalization(int marketCapitalization) {
        this.marketCapitalization = marketCapitalization;
    }

    @Override
    public String toString() {
        return "\n customerName = " + getCustomerName() + 
               "\t investmentType = " + getInvestmentType() +
               "\t symbol = " + getSymbol() +
               "\t name = " + getName() + 
               "\t quantity = " + getQuantity() + 
               "\t purchasePrice = " + getPurchasePrice() + 
               "\t currentMarketValue = " + getCurrentMarketValue() +
               "\t dividendYield = " + getDividendYield() + 
               "\t marketCapitalization = " + getMarketCapitalization();
    }
    
    /* Method is overridden from the interface. Get's the current market value
    * of the the stock object.
    */
    
    @Override
    public double calculateTotalPortfolioValue() {
        return getCurrentMarketValue(); 
    }
    
} // end of class
