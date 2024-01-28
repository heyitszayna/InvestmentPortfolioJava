package financecorp;

/* interface holds the abstract method used for calculating the total
 * portfolio value of the customer. The method is called in the investment 
 * classes.
 */

public interface PortfolioValue {
    double calculateTotalPortfolioValue();
} // end of interface
