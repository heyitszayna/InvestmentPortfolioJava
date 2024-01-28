package financecorp;

public class Bond extends Investment implements PortfolioValue{
    private int couponRate;
    private String maturityDate;
    
    public Bond(String customerName, String investmentType, String symbol, String name, int quantity, int purchasePrice, int currentMarketValue, int couponRate, String maturityDate) {
        super(customerName, investmentType, symbol, name, quantity, purchasePrice, currentMarketValue);
        this.couponRate = couponRate;
        this.maturityDate = maturityDate;
    } // end of paramterized constructor

    public int getCouponRate() {
        return couponRate;
    }

    public void setCouponRate(int couponRate) {
        this.couponRate = couponRate;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
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
               "\t couponRate = " + getCouponRate() + 
               "\t maturityDate = " + getMaturityDate();
    }
    
    /* Method is overridden from the interface. Get's the current market value
    * of the the bond object.
    */
    
    @Override
    public double calculateTotalPortfolioValue() {
        return getCurrentMarketValue(); 
    }
    
} // end of class
