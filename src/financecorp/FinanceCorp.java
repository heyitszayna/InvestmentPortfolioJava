package financecorp;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class FinanceCorp {
    public static  ArrayList<Investment> portfolio = new ArrayList<Investment>();
    
    public static void main(String[] args) {
        int userChoice;
        do {
            DislayMenu();
            userChoice = UserMenuChoice();
            switch (userChoice) {
                case 1: AddInvestmentToPortfolio(); break; 	// 1-	Add a new investment to a portfolio.
		case 2: UpdateInvestmentDetails(); break;	// 2-	Update investment details (quantity, purchase price, ...).
		case 3: 
                    try {
                        AddInvestmentsFromFile(); break;	// 3-	Bulk addition of investments from a file.
                    } catch (FileNotFoundException e) {
                        System.err.println("File not found: " + e.getMessage());
                    }
		case 4: ListAllInvestments(); break;		// 4-	List all investments in the portfolio of a selected customer.
		case 5: CalculatePortfolioValue(); break;       // 5-	Calculate the total portfolio value for a selected customer.

		default:  System.out.println("Thank you for using CSC301's Investment Portfolio Management System, Have a Good Bye.");
            }
	} while (userChoice != 0);
    } // end of main
    
    public static void DislayMenu() {
        System.out.println("-------------------------------------------------------------------");
	System.out.println("Investment Portfolio Management System (FinanceCorp, Spring2024)");
	System.out.println("-------------------------------------------------------------------");
	System.out.println("1- Add a new investment to a portfolio.");
	System.out.println("2- Update investment details (quantity, purchase price, ...).");
	System.out.println("3- Bulk addition of investments from a file.");
	System.out.println("4- List all investments in the portfolio of a selected customer.");
	System.out.println("5- Calculate the total portfolio value for a selected customer.");
	System.out.println("0- Quit");
	System.out.println("-------------------------------------------------------------------");
    } // end of menu
    
    public static int UserMenuChoice() {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Your choice (0, 1, 2, 3, 4, 5):");
            choice = input.nextInt();
        } while(choice > 5);
        return choice;
    } // end of menu
    
    /* Asks the user for which type of investment and takes the respective attributes
     * from them. It then creates the required object and adds it to the portfolio.
     */
    
    public static void AddInvestmentToPortfolio() {
        Scanner input = new Scanner(System.in);
        
        String investmentType = InvestmentSelection();
        
        if ("Stock".equals(investmentType)) {
            System.out.println("Enter customer name: ");
            String customerName = input.nextLine();
            System.out.println("Enter customer ID: ");
            String customerID = input.nextLine();
            System.out.println("Enter stock symbol: ");
            String symbol = input.nextLine();
            System.out.println("Enter stock name: ");
            String name = input.nextLine();
            System.out.println("Enter stock quantity: ");
            int quantity = Integer.parseInt(input.nextLine());
            System.out.println("Enter stock purchase price: ");
            int purchasePrice = Integer.parseInt(input.nextLine());
            System.out.println("Enter stock current market value: ");
            int currentMarketValue = Integer.parseInt(input.nextLine());
            System.out.println("Enter stock dividend yield: ");
            int dividendYield = Integer.parseInt(input.nextLine());
            System.out.println("Enter stock market capitalization: ");
            int marketCapatilization = Integer.parseInt(input.nextLine());
            portfolio.add(new Stock(customerName, customerID, symbol, name, quantity, purchasePrice, currentMarketValue, dividendYield, marketCapatilization));
        } else if ("Bond".equals(investmentType)) {
            System.out.println("Enter customer name: ");
            String customerName = input.nextLine();
            System.out.println("Enter customer ID: ");
            String customerID = input.nextLine();
            System.out.println("Enter bond symbol: ");
            String symbol = input.nextLine();
            System.out.println("Enter bond name: ");
            String name = input.nextLine();
            System.out.println("Enter bond quantity: ");
            int quantity = Integer.parseInt(input.nextLine());
            System.out.println("Enter bond purchase price: ");
            int purchasePrice = Integer.parseInt(input.nextLine());
            System.out.println("Enter bond current market value: ");
            int currentMarketValue = Integer.parseInt(input.nextLine());
            System.out.println("Enter bond coupon rate: ");
            int couponRate = Integer.parseInt(input.nextLine());
            System.out.println("Enter bond maturity date: ");
            String maturityDate = input.nextLine();
            portfolio.add(new Bond(customerName, customerID, symbol, name, quantity, purchasePrice, currentMarketValue, couponRate, maturityDate));
        } else if ("Mutual Fund".equals(investmentType)) {
            System.out.println("Enter customer name: ");
            String customerName = input.nextLine();
            System.out.println("Enter customer ID: ");
            String customerID = input.nextLine();
            System.out.println("Enter mutual fund symbol: ");
            String symbol = input.nextLine();
            System.out.println("Enter mutual fund name: ");
            String name = input.nextLine();
            System.out.println("Enter mutual fund quantity: ");
            int quantity = Integer.parseInt(input.nextLine());
            System.out.println("Enter mutual fund purchase price: ");
            int purchasePrice = Integer.parseInt(input.nextLine());
            System.out.println("Enter mutual fund current market value: ");
            int currentMarketValue = Integer.parseInt(input.nextLine());
            System.out.println("Enter mutual fund expense rate: ");
            int expenseRate = Integer.parseInt(input.nextLine());
            System.out.println("Enter mutual fund investment style: ");
            String investmentStyle = input.nextLine();
            portfolio.add(new MutualFund(customerName, customerID, symbol, name, quantity, purchasePrice, currentMarketValue, expenseRate, investmentStyle));
        }
        
        System.out.println("\t \t \t =============== Portfolio ===============");
        for (Investment i : portfolio) {
            System.out.println(i.toString());
        }
    }
    
    /* Asks user to update which attribute of which property and then displays
     * the updated portfolio at the end
     */
    
    public static void UpdateInvestmentDetails() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter customer name: ");
        String cname = input.nextLine();
        
        String investmentType = InvestmentSelection();
        int choice = PropertyUpdate();
        
        if ("Stock".equals(investmentType)) {
            for (Investment stock : portfolio) {
                if (stock instanceof Stock) {
                    if (stock.getCustomerName().equals(cname)) {
                        switch (choice) {
                            case 1:
                                System.out.println("Enter new stock symbol: ");
                                String symbol = input.nextLine();
                                stock.setSymbol(symbol);
                                break;
                            case 2:
                                System.out.println("Enter new stock name: ");
                                String name = input.nextLine();
                                stock.setName(name);
                                break;
                            case 3:
                                System.out.println("Enter new stock quantity: ");
                                int quantity = Integer.parseInt(input.nextLine()); 
                                stock.setQuantity(quantity);
                                break;
                            case 4:
                                System.out.println("Enter new stock purchase price: ");
                                int purchasePrice = Integer.parseInt(input.nextLine()); 
                                stock.setPurchasePrice(purchasePrice);
                                break;
                            case 5:
                                System.out.println("Enter new stock current market value: ");
                                int currentMarketValue = Integer.parseInt(input.nextLine()); 
                                stock.setCurrentMarketValue(currentMarketValue);
                                break;
                            default: System.out.println("Cannot update, sorry.");
                        } // end of switch
                    } // end of if 2
                } // end of if 1
            } // end of for
        } else if ("Bond".equals(investmentType)) {
            for (Investment bond : portfolio) {
                if (bond instanceof Bond) {
                    if (bond.getCustomerName().equals(cname)) {
                        switch (choice) {
                            case 1:
                                System.out.println("Enter new stock symbol: ");
                                String symbol = input.nextLine();
                                bond.setSymbol(symbol);
                                break;
                            case 2:
                                System.out.println("Enter new stock name: ");
                                String name = input.nextLine();
                                bond.setName(name);
                                break;
                            case 3:
                                System.out.println("Enter new stock quantity: ");
                                int quantity = Integer.parseInt(input.nextLine()); 
                                bond.setQuantity(quantity);
                                break;
                            case 4:
                                System.out.println("Enter new stock purchase price: ");
                                int purchasePrice = Integer.parseInt(input.nextLine()); 
                                bond.setPurchasePrice(purchasePrice);
                                break;
                            case 5:
                                System.out.println("Enter new stock current market value: ");
                                int currentMarketValue = Integer.parseInt(input.nextLine()); 
                                bond.setCurrentMarketValue(currentMarketValue);
                                break;
                            default: System.out.println("Cannot update, sorry.");
                        } // end of switch
                    } // end of if 2
                } // end of if 1
            } // end of for
        } else if ("Mutual Fund".equals(investmentType)) {
            for (Investment fund : portfolio) {
                if (fund instanceof MutualFund) {
                    if (fund.getCustomerName().equals(cname)) {
                        switch (choice) {
                            case 1:
                                System.out.println("Enter new stock symbol: ");
                                String symbol = input.nextLine();
                                fund.setSymbol(symbol);
                                break;
                            case 2:
                                System.out.println("Enter new stock name: ");
                                String name = input.nextLine();
                                fund.setName(name);
                                break;
                            case 3:
                                System.out.println("Enter new stock quantity: ");
                                int quantity = Integer.parseInt(input.nextLine()); 
                                fund.setQuantity(quantity);
                                break;
                            case 4:
                                System.out.println("Enter new stock purchase price: ");
                                int purchasePrice = Integer.parseInt(input.nextLine()); 
                                fund.setPurchasePrice(purchasePrice);
                                break;
                            case 5:
                                System.out.println("Enter new stock current market value: ");
                                int currentMarketValue = Integer.parseInt(input.nextLine()); 
                                fund.setCurrentMarketValue(currentMarketValue);
                                break;
                            default: System.out.println("Cannot update, sorry.");
                        } // end of switch
                    } // end of if 2
                } // end of if 1
            } // end of for
        } // end of entire loop
        
        System.out.println("=============== Portfolio ===============");
        for (Investment i : portfolio) {
            System.out.println(i.toString());
        }
    }
    
    /*
    * takes the file address from the user and uses scanner to read the file 
    * and add the values to the portfolio while simultaneously creating the 
    * required investment object.
    */
    
    public static void AddInvestmentsFromFile() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter file address: \n");
        String address = input.nextLine();
        
        java.io.File file = new java.io.File(address);
        Scanner readFile = new Scanner(file);
         
        String investment = InvestmentSelection();
        if ("Stock".equals(investment)) {
            while (readFile.hasNext()) {
                String customerName = readFile.next();
                String investmentType = readFile.next();
                String symbol = readFile.next();
                String name = readFile.next();
                int quantity = readFile.nextInt();
                int purchasePrice = readFile.nextInt();
                int currentMarketValue = readFile.nextInt();
                int dividendYield = readFile.nextInt();
                int marketCapitalization = readFile.nextInt();
                portfolio.add(new Stock(customerName, investmentType, symbol, name, quantity, purchasePrice, currentMarketValue, dividendYield, marketCapitalization));
            } // while end
        } else if ("Bond".equals(investment)) {
            while (readFile.hasNext()) {
                String customerName = readFile.next();
                String investmentType = readFile.next();
                String symbol = readFile.next();
                String name = readFile.next();
                int quantity = readFile.nextInt();
                int purchasePrice = readFile.nextInt();
                int currentMarketValue = readFile.nextInt();
                int couponRate = readFile.nextInt();
                String maturityDate = readFile.next();
                portfolio.add(new Bond(customerName, investmentType, symbol, name, quantity, purchasePrice, currentMarketValue, couponRate, maturityDate));
            } // while end
        } else if ("Mutual Fund".equals(investment)) {
            while (readFile.hasNext()) {
                String customerName = readFile.next();
                String investmentType = readFile.next();
                String symbol = readFile.next();
                String name = readFile.next();
                int quantity = readFile.nextInt();
                int purchasePrice = readFile.nextInt();
                int currentMarketValue = readFile.nextInt();
                int expenseRate = readFile.nextInt();
                String investmentStyle = readFile.next();
                portfolio.add(new MutualFund(customerName, investmentType, symbol, name, quantity, purchasePrice, currentMarketValue, expenseRate, investmentStyle));
            } // while end
        }
        
        readFile.close();
        
        System.out.println("=============== Portfolio ===============");
        for (Investment i : portfolio) {
            System.out.println(i.toString());
        }
    }
    
    /*
    * This method, on taking the customer name from user input, searches for it
    * in the portfolio and then displays all of their investments.
    */
    
    public static void ListAllInvestments() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter customer name: ");
        String customerName = input.nextLine();
        
        System.out.println("=============== All of " + customerName + "'s investments ===============");
        for (Investment investment: portfolio) {
            if (customerName.equals(investment.getCustomerName())) {
                System.out.println(investment.toString());
            }
        }
    }
    
    /*
    * The method calculates the sum of all the investments under a customers 
    * name by checking first if they are added to the portfolio.
    */
    
    public static void CalculatePortfolioValue() {
	Scanner input = new Scanner(System.in);
        System.out.println("Enter customer name: ");
        String customerName = input.nextLine();
        
        double totalPortfolioValue = 0.0;
        
        for (Investment investment: portfolio) {
            if (customerName.equals(investment.getCustomerName())) {
                totalPortfolioValue += investment.calculateTotalPortfolioValue();
            }
        }
        
        System.out.println(customerName + "'s total portfolio value is " + totalPortfolioValue);
    }
    
    /*
    * returns the investment type. the method is used multiple times across the 
    * program for checking equality.
    */
    
    public static String InvestmentSelection() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("-------------------------------------------");
        System.out.println("Please select the type of investment (1-3)");
        System.out.println("-------------------------------------------");
        System.out.println("1- Stock");
        System.out.println("2- Bond");
        System.out.println("3- Mutual Fund");
        System.out.println("-------------------------------------------");
        
        int choice = Integer.parseInt(input.nextLine());
        String investment = null;
        switch (choice) {
            case 1:
                investment = "Stock";
                break;
            case 2:
                investment = "Bond";
                break;
            case 3:
                investment = "Mutual Fund";
                break;
            default:
                break;
        }
        return investment;
    }
    
    /*
    * Takes the invesment type from the user and according to the type, 
    * asks which property to update
    */
    
    public static int PropertyUpdate() {
        Scanner input = new Scanner(System.in);
        
        String investmentType = InvestmentSelection();
        int choice = 0;
        if ("Stock".equals(investmentType)) {
            System.out.println("Select property for update (1-7): \n 1- Symbol \t 2- Name \t 3- Quantity \t 4- Purchase Price \t 5- Current Market Value");
            choice = Integer.parseInt(input.nextLine());
        } else if ("Bond".equals(investmentType)) {
            System.out.println("Select property for update (1-7): \n 1- Symbol \t 2- Name \t 3- Quantity \t 4- Purchase Price \t 5- Current Market Value");
            choice = Integer.parseInt(input.nextLine());
        } else if ("MutualFund".equals(investmentType)) {
            System.out.println("Select property for update (1-7): \n 1- Symbol \t 2- Name \t 3- Quantity \t 4- Purchase Price \t 5- Current Market Value");
            choice = Integer.parseInt(input.nextLine());
        } // end of everything
        
        return choice;
    }
    
} // end of class
