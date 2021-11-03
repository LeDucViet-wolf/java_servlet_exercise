package dao;

import entity.Account;

public interface AccountDAO {
	public boolean insertAccount(Account a);

	public Account getAccountById(int id);

	public boolean saveAccount(Account a);

	public boolean deleteAccount(Integer id);
}
