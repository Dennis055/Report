package Bank;



public class SavingsAccount extends BankAccount {
 private double interestRate;

 public SavingsAccount(int anAccountNumber, double initialBalance,double interestRate) {
  super(anAccountNumber, initialBalance);
  interestRate = 10;
 }
 public void addInterest() {
  double interest = getbalance() * interestRate / 100;
  deposit(interest); 

 }

}