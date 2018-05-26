package Bank;

import java.util.ArrayList;
import java.util.List;
public class BankAccount {
 
 
  private static final String status_open ="open";
  private static final String status_suspended = "suspended";
  private static final String status_closed = "close";
  
  private String accountType;
  private static final String type_savings = "savings";
  private static final String type_checking = "checking";
  private void settype(String type) {
   accountType = type;
  }
  private int accountnumber;
  protected double balance;
  private String accountState;
  private ArrayList<Double>transactions;
  private void setstatus(String status) {
   accountState = status; 
  }
  
  
  public BankAccount(int anAccountNumber, double initialBalance) {
   accountnumber = anAccountNumber; accountState = status_open;
   transactions = new ArrayList<Double>();
   deposit(initialBalance);
   }
  
  /**
   * a method to deposit the money
   * @param amount is a double number
   */
  public void deposit(double amount) {
   if(accountState.equals(status_open)&&amount>0) {
    double newbalance = balance+amount;
    balance = newbalance;
    transactions.add(amount);
   }
  }
  
  /**
   * a method to withdraw the money
   * @param amount is a double number
   */
  public void withdraw(double amount) {
   if(accountState.equals(status_open)&&amount>0&&amount<=balance) {
    double newbalance = balance-amount;
    balance = newbalance;
    amount= 0-amount;
    transactions.add(amount);
   }
  }
  /**
   * set the account status to be suspended
   */
  public void suspend() {
   if (accountState.equals(status_closed) == false)
   setstatus(status_suspended); 
   }
  /**
   * set the account status to be closed
   */
  public void close() {
   if (accountState.equals(status_closed) == false) {
   reOpen();
   withdraw(balance); }
   setstatus(status_closed); 
   }
  /**
   * reset the account status to be open
   */
  public void reOpen() {
   if(accountState.equals(status_suspended)==true) {
    setstatus(status_open);
   }
  }
  public void addTansaction(double amount) {
   transactions.add(amount);
  }
  /**
   * shows the details of the transactions
   * @return the string of results
   */
  public String getTransactions() {
   String result1 = "Account #"+accountnumber+"transactions:\n";
   System.out.println(result1);
   int i = 1;
   for(double a:transactions) {
         System.out.println(i+":"+a);
         i++;
         }
   return"Current Balance = "+balance;
      
   }
  
  public int retrieveNumberOfTransactions() {
   return transactions.size();
  }
  
  
  public boolean isOpen() {
   if (accountState.equals(status_open)) {
   return true; 
   } else {
   return false;
    }
   }
  public boolean isclosed() {
   if (accountState.equals(status_closed)) {
   return true; 
   } else {
   return false;
    }
   }
  public boolean issuspended() {
   if (accountState.equals(status_suspended)) {
   return true;
   } else {
   return false; 
    }
   }
  public String getstatus(){
   return accountState;
  }
  public int getAccountNumber() {
   return accountnumber;
  }
  public double getbalance() {
   return balance;
  }
  public String getType(){
   return accountType;
  }
  /**
   * a list refers to transaction list
   */
  public List<Double> translist = transactions;
  
  public boolean equals(Object o,Object p) {
   if(o.equals(getbalance())&&p.equals(getbalance())) {
    return true;
   }else {
    return false;
   }
  }
 }