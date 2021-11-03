package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AccountDAO;
import db.DBUtility;
import entity.Account;

public class AccountDAOImpl implements AccountDAO {
	public boolean insertAccount(Account a) {
		// TODO Auto-generated method stub
		boolean bl = false;

		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
		try {
			pstmt = con.prepareStatement("insert into Accounts values (?,?,?,?,?,?)");
			pstmt.setInt(1, a.getCustomerId());
			pstmt.setString(2, a.getAccountNumber());
			pstmt.setString(3, a.getPassword());
			pstmt.setDate(4, new Date(a.getCreateDate().getTime()));
			pstmt.setFloat(5, a.getBalance());
			pstmt.setBoolean(6, a.getStatus());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				bl = true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtility.closeAll(con, pstmt, rs);
		}
		return bl;
	}

	@Override
	public boolean deleteAccount(Integer id) {
		// TODO Auto-generated method stub
		boolean bl = false;

		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
		try {
			pstmt = con.prepareStatement("update Accounts set Status = 0 where AccountId=?");
			pstmt.setInt(1, id);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				bl = true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtility.closeAll(con, pstmt, rs);
		}
		return bl;
	}

	@Override
	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		Account a = null;

		Connection con;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
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
		// TODO Auto-generated method stub
		boolean bl = false;

		Connection con;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
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
