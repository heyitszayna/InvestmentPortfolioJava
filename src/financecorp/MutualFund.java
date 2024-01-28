package financecorp;

public class MutualFund extends Investment implements PortfolioValue{
    private int expenseRate;
    private String investmentStyle;
    
    public MutualFund(String customerName, String investmentType, String symbol, String name, int quantity, int purchasePrice, int currentMarketValue, int expenseRate, String investmentStyle) {
        super(customerName, investmentType, symbol, name, quantity, purchasePrice, currentMarketValue);
        this.expenseRate = expenseRate;
        this.investmentStyle = investmentStyle;
    } // end of paramterized constructor

    public int getExpenseRate() {
        return expenseRate;
    }

    public void setExpenseRate(int expenseRate) {
        this.expenseRate = expenseRate;
    }

    public String getInvestmentStyle() {
        return investmentStyle;
    }

    public void setInvestmentStyle(String investmentStyle) {
        this.investmentStyle = investmentStyle;
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
               "\t expenseRate = " + getExpenseRate() + 
               "\t investmentStyle = " + getInvestmentStyle();
    }
    
    /* Method is overridden from the interface. Get's the current market value
    * of the mutual fund object.
    */
    
    @Override
    public double calculateTotalPortfolioValue() {
        return getCurrentMarketValue(); 
    }
    
} // end of class
