package com.revature.models;

public abstract class BankAccount {

	protected int accountNumber;
	private double startingBalance;
	protected double accountBalance;
	private String accountType;
	private String accountStatus;
	protected double deposit;
	protected double withdraw;
	private double transaction;
	
	
	public double getTransaction() {
		return transaction;
	}
	public abstract void setTransaction(String accountType, double deposit, double withdraw);

	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getWithdraw() {
		return withdraw;
	}
	public double getStartingBalance() {
		return startingBalance;
	}
	public void setStartingBalance(double startingBalance) {
		this.startingBalance = startingBalance;
		startingBalance = accountBalance;
	}
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance, double deposit, double withdraw) {
		if (deposit > 0 && withdraw == 0) {
			accountBalance = startingBalance + deposit;
			System.out.println("Your balance is " + accountBalance);
		} else if (withdraw < accountBalance && withdraw > 0 && deposit == 0) {
			accountBalance = startingBalance - withdraw;
			System.out.println("Your balance is " + accountBalance);
		} else {
			System.out.println("Your balance is " + accountBalance);
		}
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
}