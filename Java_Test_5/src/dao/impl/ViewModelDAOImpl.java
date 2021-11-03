package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ViewModelDAO;
import db.DBUtility;
import entity.ViewModel;

public class ViewModelDAOImpl implements ViewModelDAO {

	@Override
	public List<ViewModel> getListViewModel() {
		// TODO Auto-generated method stub
		List<ViewModel> list = new ArrayList<ViewModel>();

		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
		try {
			pstmt = con.prepareStatement(
					"select * from Customers c left join Accounts a on a.CustomerId = c.CustomerId where c.Status = 1");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ViewModel vm = new ViewModel();
				vm.setAccountId(rs.getInt("AccountId"));
				vm.setCustomerId(rs.getInt("CustomerId"));
				vm.setCustomerName(rs.getString("CustomerName"));
				vm.setGender(rs.getBoolean("Gender"));
				vm.setBirthday(rs.getDate("Birthday"));
				vm.setAddress(rs.getString("Address"));
				vm.setAccountNumber(rs.getString("AccountNumber"));
				vm.setCreateDate(rs.getDate("CreatedDate"));
				vm.setBalance(rs.getFloat("Balance"));
				list.add(vm);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtility.closeAll(con, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<ViewModel> SearchByName(String name) {
		// TODO Auto-generated method stub
		List<ViewModel> list = new ArrayList<ViewModel>();

		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
		try {
			pstmt = con.prepareStatement(
					"select * from Customers c left join Accounts a" + " on a.CustomerId = c.CustomerId"
							+ " where c.CustomerName like '%" + name + "%' and c.Status = 1");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ViewModel vm = new ViewModel();
				vm.setAccountId(rs.getInt("AccountId"));
				vm.setCustomerId(rs.getInt("CustomerId"));
				vm.setCustomerName(rs.getString("CustomerName"));
				vm.setGender(rs.getBoolean("Gender"));
				vm.setBirthday(rs.getDate("Birthday"));
				vm.setAddress(rs.getString("Address"));
				vm.setAccountNumber(rs.getString("AccountNumber"));
				vm.setCreateDate(rs.getDate("CreatedDate"));
				vm.setBalance(rs.getFloat("Balance"));
				list.add(vm);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtility.closeAll(con, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<ViewModel> SearchById(int id) {
		// TODO Auto-generated method stub
		List<ViewModel> list = new ArrayList<ViewModel>();

		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		con = DBUtility.openConnection();
		try {
			pstmt = con.prepareStatement(
					"select * from Customers c left join Accounts a" + " on a.CustomerId = c.CustomerId"
							+ " where (a.CustomerId = " + id + " or a.AccountId = " + id + ") and c.Status = 1");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ViewModel vm = new ViewModel();
				vm.setAccountId(rs.getInt("AccountId"));
				vm.setCustomerId(rs.getInt("CustomerId"));
				vm.setCustomerName(rs.getString("CustomerName"));
				vm.setGender(rs.getBoolean("Gender"));
				vm.setBirthday(rs.getDate("Birthday"));
				vm.setAddress(rs.getString("Address"));
				vm.setAccountNumber(rs.getString("AccountNumber"));
				vm.setCreateDate(rs.getDate("CreatedDate"));
				vm.setBalance(rs.getFloat("Balance"));
				list.add(vm);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtility.closeAll(con, pstmt, rs);
		}
		return list;
	}

}
