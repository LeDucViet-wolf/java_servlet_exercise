package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AccountDAO;
import db.DBUtility;
import entity.Account;
import entity.Customer;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public boolean insertAccount(Account a) {
		boolean bl = false;

		Connection con;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		con = DBUtility.openConnect();
		try {
			pstm = con.prepareStatement("INSERT INTO Accounts VALUES (?,?,?,?,?,?)");
			pstm.setInt(1, a.getCustomerId());
			pstm.setString(2, a.getAccountNumber());
			pstm.setString(3, a.getPassword());
			pstm.setDate(4, new Date(a.getCreateDate().getTime()));
			pstm.setFloat(5, a.getBalance());
			pstm.setBoolean(6, a.getStatus());

			int i = pstm.executeUpdate();
			if (i > 0)
				bl = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtility.closeAll(con, pstm, rs);
		}

		return bl;
	}

	@Override
	public Account getAccountById(int id) {
		Account a = null;

		Connection con;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		con = DBUtility.openConnect();
		try {
			pstm = con.prepareStatement("SELECT * FROM Accounts WHERE AccountId=?");
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				a = new Account();
				a.setAccountId(rs.getInt("AccountId"));
				a.setCustomerId(rs.getInt("CustomerId"));
				a.setAccountNumber(rs.getString("AccountNumber"));
				a.setPassword(rs.getString("Password"));
				a.setCreateDate(rs.getDate("CreatedDate"));
				a.setBalance(rs.getFloat("Balance"));
				a.setStatus(rs.getBoolean("Status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtility.closeAll(con, pstm, rs);
		}

		return a;
	}

	@Override
	public boolean saveAccount(Account a) {
		boolean bl = false;

		Connection con;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		con = DBUtility.openConnect();
		try {
			pstm = con.prepareStatement(
					"UPDATE Accounts SET AccountNumber=?,Password=?,CreatedDate=?,Balance=?,Status=?,CustomerId=? WHERE AccountId=?");
			pstm.setString(1, a.getAccountNumber());
			pstm.setString(2, a.getPassword());
			pstm.setDate(3, new Date(a.getCreateDate().getTime()));
			pstm.setFloat(4, a.getBalance());
			pstm.setBoolean(5, a.getStatus());
			pstm.setInt(6, a.getCustomerId());
			pstm.setInt(7, a.getAccountId());

			int i = pstm.executeUpdate();
			if (i > 0)
				bl = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtility.closeAll(con, pstm, rs);
		}

		return bl;
	}

}
