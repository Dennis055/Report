 package Bank;

 public class Tester {
	public static void main(String[] args) {
		Bank user = new Bank(); 
		user.addSavingsAccount(1001, 100.5, 90.5); 
		user.deposit(1001, 300);
		user.withdraw(1001, 100);
		user.addCheckingAccount(1005, 300.1);
		user.withdraw(1005, 200);
		user.closeAccount(1005);
		user.addCheckingAccount(1010, 90.5);
		user.suspendAccount(1010);
		user.withdraw(1010, 40);
		user.addSavingsAccount(1030, 1000.0,0.5);
		user.deposit(1030, 1500);
		user.transfer(1001,1030,200.1);
		user.addCheckingAccount(1100, 1200);
		user.addInterest(1001);
		user.deductFees(1100);
		
		
		
		
		System.out.println(user.summarizeAccountTransactions(1001)); 
		System.out.println(user.summarizeAccountTransactions(1100));
		System.out.println(user.summarizeAccountTransactions(1005)); 
		System.out.println(user.summarizeAccountTransactions(1010)); 
		System.out.println(user.summarizeAllAccounts());
		
		} 

}
