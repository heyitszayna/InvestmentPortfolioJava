package financecorp_g4;

/*
 * CSC301 Assignment 1
 * Done by: Zayna Wasma (1084503)
 */

public class Bond_G4 extends Investment_G4 implements PortfolioValue_G4{
    private int couponRate;
    private String maturityDate;
    
    public Bond_G4(String customerName, String investmentType, String symbol, String name, int quantity, int purchasePrice, int currentMarketValue, int couponRate, String maturityDate) {
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
    
    /* Method is overriden from the interface. get;s the current market value
    * of the the bond object.
    */
    
    @Override
    public double calculateTotalPortfolioValue() {
        return getCurrentMarketValue(); 
    }
    
} // end of class
