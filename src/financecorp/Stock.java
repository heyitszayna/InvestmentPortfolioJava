package financecorp_g4;

/*
 * CSC301 Assignment 1
 * Done by: Zayna Wasma (1084503)
 */

public class Stock_G4 extends Investment_G4 implements PortfolioValue_G4{
    private int dividendYield;
    private int marketCapitalization;
    
    public Stock_G4(String customerName, String investmentType, String symbol, String name, int quantity, int purchasePrice, int currentMarketValue, int dividendYield, int marketCapitalization) {
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
    
    /* Method is overriden from the interface. get;s the current market value
    * of the the stock object.
    */
    
    @Override
    public double calculateTotalPortfolioValue() {
        return getCurrentMarketValue(); 
    }
    
} // end of class
