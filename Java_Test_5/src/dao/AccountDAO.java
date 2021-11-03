package dao;

import entity.Account;
import entity.Customer;

public interface AccountDAO {
	public boolean insertAccount(Account c);
	
	public Account getAccountById(int id);
	
	public boolean saveAccount(Account c);
}
