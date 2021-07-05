package models;

public abstract class BankAccount {

	private String username;
	private int account_Number;
	private double account_Balance;
	private String account_Type;
	private String account_Status;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public void setAccount_Balance(double account_Balance) {
		this.account_Balance = account_Balance;
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
