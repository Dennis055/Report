package Bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
 
 
 private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
 public List<BankAccount> accountlist = accounts; //把accounts的內容送到accountlist
 
 
 private BankAccount find(int anAccountNumber) {
        for (BankAccount account : accounts) {
  if (account.getAccountNumber() == anAccountNumber) 
   return account;
   }
  return null;
  }
 public void deposit(int accountNumber, double initialBalance) {
  find(accountNumber).deposit(initialBalance);
 }
 public void withdraw(int accountNumber, double initialBalance) {
  find(accountNumber).withdraw(initialBalance);
 }
 public double getBalance(int accountNumber) {
  return find(accountNumber).getbalance();
 }
 public void suspendAccount(int accountNumber) {
  find(accountNumber).suspend();
 }
 public void reOpenAccount(int accountNumber) {
  find(accountNumber).reOpen();
 }
 public void closeAccount(int accountNumber) {
  find(accountNumber).close();
 }
 public String getAccountStatus(int accountNumber) {
  return find(accountNumber).getstatus();
 }
 public String summarizeAccountTransactions(int accountNumber) {
  return find(accountNumber).getTransactions();
 }
 public String summarizeAllAccounts() {
  String type = null;
  String string1 = "Bank Account Summary\n";
  System.out.println(string1); 
  String string4 = String.format("Account   Type    Balance    #Transactions      Status");
  System.out.println(string4);
  for(BankAccount account:accounts) {
   if(account instanceof CheckingAccount) {type= "Checking";}
   if(account instanceof SavingsAccount) {type = "Savings";}
  String string5 =String.format("%1d%10s%10.1f%17d%12s",account.getAccountNumber(),type,account.getbalance(),account.retrieveNumberOfTransactions(),account.getstatus());
  System.out.println(string5);
  }
  return "End of Account Summary"; 
  }

 
 public void addSavingsAccount(int accountNumber, double initialBalance, double interestRate) {
  SavingsAccount a = new SavingsAccount( accountNumber, initialBalance, interestRate);
  accountlist.add(a);
  
 } 
 
 public void addCheckingAccount(int accountNumber, double initialBalance) {
  CheckingAccount a = new CheckingAccount(accountNumber, initialBalance);
  accountlist.add(a);
  
 }
 public void addInterest(int accountNumber) {
  if(find(accountNumber) instanceof SavingsAccount) {
   ((SavingsAccount) find(accountNumber)).addInterest();}
 }
 public void deductFees(int accountNumber) {
  if(find(accountNumber) instanceof CheckingAccount) {
  ((CheckingAccount) find(accountNumber)).deductFees();}
 }
 
 public void transfer(int withdrawAcctNum,int depositAcctNum, double amount) {
  if(amount<=getBalance(withdrawAcctNum)) {
   withdraw(withdrawAcctNum,amount);
   deposit(depositAcctNum,amount);
  }else if(amount>getBalance(withdrawAcctNum)) {
   System.out.println("\nTransfer failed, not enough balance!");
  }
  
 }
 public boolean areEqualAccounts(int accountNumber1, int accountNumber2) {
  return find(accountNumber1).equals(find(accountNumber2));
   
   
 }
 

}