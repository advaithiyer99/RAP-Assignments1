package com.revature.models;

public class Checking extends BankAccount {

	public Checking (String accountType, int accountNumber, String accountStatus, double startingBalance, double deposit, double withdraw, double transaction, double accountBalance) {
		this.setAccountType("Checking");
		this.setAccountNumber(accountNumber);
		this.setAccountStatus(accountStatus);
		this.setStartingBalance(startingBalance);
		this.setDeposit(deposit);
		this.setWithdraw(withdraw);
		this.setTransaction(this.getAccountType(), deposit, withdraw);
		this.setAccountBalance(accountBalance, deposit, withdraw);
	}

	public Checking(int accountNumber, double accountBalance, String accountStatus, String accountType) {
		this.setAccountNumber(accountNumber);
		this.setAccountBalance(accountBalance, deposit, withdraw);
		this.setAccountStatus(accountStatus);
		this.setAccountType(accountType);
	}

	@Override
	public void setTransaction(String accountType, double deposit, double withdraw) {
		if (deposit > 0 && withdraw == 0) {
			System.out.println(deposit);
			System.out.println("You have deposited " + deposit + " dollars into your checking account!");
		} else if (withdraw < accountBalance && withdraw > 0 && deposit == 0) {
			System.out.println(withdraw);
			System.out.println("You have withdrawn " + withdraw + " dollars from your checking account!");
		} else if (withdraw >= accountBalance) {
			System.out.println("This transaction is invalid!");
			this.setWithdraw(withdraw);
		} else {
			System.out.println("You have completed your transaction! Have a nice day!");
		}
	}
}
