package entity;

import java.util.Date;

public class Account {
	private Integer accountId;
	private Integer customerId;
	private String accountNumber;
	private String password;
	private Date createDate;
	private Float balance;
	private Boolean status;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Integer accountId, Integer customerId, String accountNumber, String password, Date createDate,
			Float balance, Boolean status) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.password = password;
		this.createDate = createDate;
		this.balance = balance;
		this.status = status;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
