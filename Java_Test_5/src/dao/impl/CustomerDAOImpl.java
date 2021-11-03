package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CustomerDAO;
import db.DBUtility;
import entity.Account;
import entity.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public boolean insertCustomer(Customer c) {
		// TODO Auto-generated method stub
		boolean bl = false;

		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
		try {
			pstmt = con.prepareStatement("insert into Customers values (?,?,?,?,?,?,?)");
			pstmt.setString(1, c.getCustomerName());
			pstmt.setBoolean(2, c.getGender());
			pstmt.setDate(3, new Date(c.getBirthday().getTime()));
			pstmt.setString(4, c.getAddress());
			pstmt.setString(5, c.getEmail());
			pstmt.setString(6, c.getTelephone());
			pstmt.setBoolean(7, c.getStatus());
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

	public boolean validatePhone(String phone, String id) {
		boolean bl = false;

		Connection con;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
		try {
			pstm = con.prepareStatement("SELECT * FROM Customers c WHERE c.Telephone=?");
			if (!id.equals("")) {
				int customerId = Integer.parseInt(id);
				Customer c = this.getCustomerById(customerId);
				if (phone.equals(c.getTelephone())) {
					bl = false;
				} else {
					pstm.setString(1, phone);
					rs = pstm.executeQuery();
					if (rs.next()) {
						bl = true;
					}
				}
			} else {
				pstm.setString(1, phone);
				rs = pstm.executeQuery();
				if (rs.next()) {
					bl = true;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtility.closeAll(con, pstm, rs);
		}

		return bl;
	}

	public boolean validateEmail(String email, String id) {
		boolean bl = false;

		Connection con;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
		try {
			pstm = con.prepareStatement("SELECT * FROM Customers c WHERE c.Email=?");
			if (!id.equals("")) {
				int customerId = Integer.parseInt(id);
				Customer c = this.getCustomerById(customerId);
				if (email.equals(c.getEmail())) {
					bl = false;
				} else {
					pstm.setString(1, email);
					rs = pstm.executeQuery();
					if (rs.next()) {
						bl = true;
					}
				}
			} else {
				pstm.setString(1, email);
				rs = pstm.executeQuery();
				if (rs.next()) {
					bl = true;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtility.closeAll(con, pstm, rs);
		}

		return bl;
	}

	public boolean validateTelephone(String telephone) {
		// TODO Auto-generated method stub
		boolean bl = false;

		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
		try {
			pstmt = con.prepareStatement("select * from Customers c where c.Telephone=?");
			pstmt.setString(1, telephone);
			rs = pstmt.executeQuery();
			if (rs.next()) {
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

	public boolean validateEmail(String email) {
		// TODO Auto-generated method stub
		boolean bl = false;

		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
		try {
			pstmt = con.prepareStatement("select * from Customers c where c.Email=?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
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
	public boolean deleteCustomer(Integer id) {
		// TODO Auto-generated method stub
		boolean bl = false;

		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
		try {
			pstmt = con.prepareStatement("update Customers set Status = 0 where CustomerId=?");
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
	public List<Customer> getListCustomer() {
		// TODO Auto-generated method stub
		List<Customer> list = new ArrayList<Customer>();

		Connection con;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
		try {
			pstm = con.prepareStatement("SELECT * FROM Customers");
			rs = pstm.executeQuery();
			while (rs.next()) {
				Customer c = new Customer();
				c.setCustomerId(rs.getInt("CustomerId"));
				c.setCustomerName(rs.getString("CustomerName"));
				c.setGender(rs.getBoolean("Gender"));
				c.setBirthday(rs.getDate("Birthday"));
				c.setAddress(rs.getString("Address"));
				c.setEmail(rs.getString("Email"));
				c.setTelephone(rs.getString("Telephone"));
				c.setStatus(rs.getBoolean("Status"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtility.closeAll(con, pstm, rs);
		}

		return list;
	}

	public boolean validateCustomerId(String customerId, String accountId) {
		boolean bl = false;

		Connection con;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
		try {
			pstm = con.prepareStatement("SELECT * FROM Accounts a WHERE a.CustomerId=?");
			if (!accountId.equals("")) {
				int accountIdToInt = Integer.parseInt(accountId);
				Account a = new AccountDAOImpl().getAccountById(accountIdToInt);
				if (customerId.equals(a.getCustomerId().toString())) {
					return false;
				}
			}
			pstm.setString(1, customerId);
			rs = pstm.executeQuery();
			if (rs.next()) {
				bl = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtility.closeAll(con, pstm, rs);
		}

		return bl;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer c = null;

		Connection con;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
		try {
			pstm = con.prepareStatement("SELECT * FROM Customers WHERE CustomerId=?");
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				c = new Customer();
				c.setCustomerId(rs.getInt("CustomerId"));
				c.setCustomerName(rs.getString("CustomerName"));
				c.setGender(rs.getBoolean("Gender"));
				c.setBirthday(rs.getDate("Birthday"));
				c.setAddress(rs.getString("Address"));
				c.setEmail(rs.getString("Email"));
				c.setTelephone(rs.getString("Telephone"));
				c.setStatus(rs.getBoolean("Status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtility.closeAll(con, pstm, rs);
		}

		return c;
	}

	@Override
	public boolean saveCustomer(Customer c) {
		boolean bl = false;

		Connection con;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
		try {
			pstm = con.prepareStatement(
					"UPDATE Customers SET CustomerName=?,Gender=?,Birthday=?,Address=?,Email=?,Telephone=?,Status=? WHERE CustomerId=?");
			pstm.setString(1, c.getCustomerName());
			pstm.setBoolean(2, c.getGender());
			pstm.setDate(3, new Date(c.getBirthday().getTime()));
			pstm.setString(4, c.getAddress());
			pstm.setString(5, c.getEmail());
			pstm.setString(6, c.getTelephone());
			pstm.setBoolean(7, c.getStatus());
			pstm.setInt(8, c.getCustomerId());

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
