package com.revature.models;

public class Savings extends BankAccount {
	
	public Savings (String account_Type, int account_Number, String account_Status, double starting_Balance, double deposit, double withdraw, double transaction, double account_Balance) {
		this.setAccount_Type("Savings");
		this.setAccount_Number(account_Number);
		this.setAccount_Status(account_Status);
		this.setStarting_Balance(starting_Balance);
		this.setDeposit(deposit);
		this.setWithdraw(withdraw);
		this.setTransaction(this.getAccount_Type(), deposit, withdraw);
		this.setAccount_Balance(account_Balance, deposit, withdraw);
	}
}
