package model.entities;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	
	//CONSTRUCTOS METOD
	public Account() {
		
	}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		setNumber(number);
		setHolder(holder);
		setBalance(balance);
		setWithdrawLimit(withdrawLimit);
	}

	
	//SETS AND GETS
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	//OTHERS METODS
	
	public void deposit(Double amount) {
		balance += amount;
		
	}
	
	public void withdraw(Double amount) throws IllegalAccessException {
		validateWithdrawLimit(amount);
		balance -= amount;
	}
	
	private void validateWithdrawLimit(Double amount) throws IllegalAccessException {
		if(amount > getWithdrawLimit()) {
			throw new IllegalAccessException("Error in withdraw: the amount exceeds withdraw limit!");
		}
		if(amount > getBalance()) {
			throw new IllegalAccessException("Error in withdraw: not enough balance!");
		}
	}
	
}
