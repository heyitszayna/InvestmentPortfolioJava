package financecorp;

public abstract class Investment implements PortfolioValue{
    private String customerName;
    private String investmentType;
    private String symbol;
    private String name;
    private int quantity;
    private int purchasePrice;
    private int currentMarketValue;
    
    public Investment(String customerName, String investmentType, String symbol, String name, int quantity, int purchasePrice, int currentMarketValue) {
        this.customerName = customerName;
        this.investmentType = investmentType;
        this.symbol = symbol;
        this.name = name;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.currentMarketValue = currentMarketValue;
    } // end of parameterized constructor

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(String investmentType) {
        this.investmentType = investmentType;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getCurrentMarketValue() {
        return currentMarketValue;
    }

    public void setCurrentMarketValue(int currentMarketValue) {
        this.currentMarketValue = currentMarketValue;
    }

    @Override
    public String toString() {
        return "\n customerName = " + getCustomerName() + 
               "\t investmentType = " + getInvestmentType() + 
               "\t symbol = " + getSymbol() + 
               "\t name = " + getName() + 
               "\t quantity = " + getQuantity() +
               "\t purchasePrice = " + getPurchasePrice() + 
               "\t currentMarketValue = " + getCurrentMarketValue();
    }
    
    /* Method is overridden from the interface. Get's the current market value
    * of an investment object.
    */
    
    @Override
    public double calculateTotalPortfolioValue() {
        return getCurrentMarketValue(); 
    }
  
} // end of class
