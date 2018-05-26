package Bank;



public class CheckingAccount extends BankAccount   {
 
 private static final int FREE_TRANSACTIONS = 3;
 private static final double TRANSACTION_FEE = 2.0;
 private int transactionCount;

 public CheckingAccount(int anAccountNumber, double initialBalance) {
  super(anAccountNumber, initialBalance);
  transactionCount = 0; 
 }
 public void deposit(double amount) {
  super.deposit(amount);
 }
 
 public void withdraw(double amount) {
  if(amount != 0 ) {
   transactionCount++;
   super.withdraw(amount); 
  }
 }
 
 public void deductFees() {
  if (transactionCount > FREE_TRANSACTIONS) {
   double fees = TRANSACTION_FEE *(transactionCount - FREE_TRANSACTIONS);
   if(fees > balance) {
   super.withdraw(balance);
   }else {
   super.withdraw(fees);}
  }

 }
 

}