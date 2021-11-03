package entity;

import java.util.Date;

public class ViewModel {
	private Integer customerId;
	private String customerName;
	private Boolean gender;
	private Date birthday;
	private String address;
	private String email;
	private String telephone;
	private Boolean status;
	
	private Integer accountId;
	private String accountNumber;
	private Date createDate;
	private Float balance;
	
	public ViewModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ViewModel(Integer customerId, String customerName, Boolean gender, Date birthday, String address,
			String email, String telephone, Boolean status, Integer accountId, String accountNumber, Date createDate,
			Float balance) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.telephone = telephone;
		this.status = status;
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.createDate = createDate;
		this.balance = balance;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
	
	
}
