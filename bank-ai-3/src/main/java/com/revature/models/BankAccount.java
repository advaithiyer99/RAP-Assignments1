package com.revature.models;

public abstract class BankAccount {

	private int account_Number;
	private double starting_Balance;
	private double account_Balance;
	private String account_Type;
	private String account_Status;
	private double deposit;
	private double withdraw;
	private double transaction;
	
	public double getTransaction() {
		return transaction;
	}
	public void setTransaction(String account_Type, double deposit, double withdraw) {
		switch(account_Type) {
		case "Checking": 
			if (deposit > 0 && withdraw == 0) {
				System.out.println(deposit);
				System.out.println("You have deposited " + deposit + " dollars into your checking account!");
			} else if (withdraw < account_Balance && withdraw > 0 && deposit == 0) {
				System.out.println(withdraw);
				System.out.println("You have withdrawn " + withdraw + " dollars from your checking account!");
			} else if (withdraw >= account_Balance) {
				System.out.println("This transaction is invalid!");
				this.setWithdraw(withdraw);
			} else {
				System.out.println("You have completed your transaction! Have a nice day!");
			}
			break; 
		case "Savings": 
			if (deposit > 0 && withdraw == 0) {
				System.out.println(deposit);
				System.out.println("You have deposited " + deposit + " dollars into your savings account!");
			} else if (withdraw < account_Balance && withdraw > 0 && deposit == 0) {
				System.out.println(withdraw);
				System.out.println("You have withdrawn " + withdraw + " dollars from your savings account!");
			} else if (withdraw >= account_Balance) {
				System.out.println("This transaction is invalid!");
				this.setWithdraw(withdraw);
			} else {
				System.out.println("You have completed your transaction! Have a nice day!");
			}
			break;
		default: 
			break;
		}
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getWithdraw() {
		return withdraw;
	}
	public double getStarting_Balance() {
		return starting_Balance;
	}
	public void setStarting_Balance(double starting_Balance) {
		this.starting_Balance = starting_Balance;
		starting_Balance = account_Balance;
	}
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	
	public int getAccount_Number() {
		return account_Number;
	}
	public void setAccount_Number(int account_Number) {
		this.account_Number = account_Number;
	}
	public double getAccount_Balance() {
		return account_Balance;
	}
	public void setAccount_Balance(double account_Balance, double deposit, double withdraw) {
		if (deposit > 0 && withdraw == 0) {
			account_Balance = starting_Balance + deposit;
			System.out.println("Your balance is " + account_Balance);
		} else if (withdraw < account_Balance && withdraw > 0 && deposit == 0) {
			account_Balance = starting_Balance - withdraw;
			System.out.println("Your balance is " + account_Balance);
		} else {
			System.out.println("Your balance is " + account_Balance);
		}
	}
	public String getAccount_Type() {
		return account_Type;
	}
	public void setAccount_Type(String account_Type) {
		this.account_Type = account_Type;
	}
	public String getAccount_Status() {
		return account_Status;
	}
	public void setAccount_Status(String account_Status) {
		this.account_Status = account_Status;
	}
}