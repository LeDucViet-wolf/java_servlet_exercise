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

		con = DBUtility.openConnect();
		try {
			pstmt = con.prepareStatement("SELECT * FROM Customers c LEFT JOIN Accounts a ON a.CustomerId = c.CustomerId WHERE c.Status = 1");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ViewModel vm = new ViewModel();
				vm.setAccountId(rs.getInt("AccountId"));
				vm.setCustomerName(rs.getString("CustomerName"));
				vm.setGender(rs.getBoolean("Gender"));
				vm.setBirthday(rs.getDate("Birthday"));
				vm.setAddress(rs.getString("Address"));
				vm.setAccountNumber(rs.getString("AccountNumber"));
				vm.setCreateDate(rs.getDate("CreatedDate"));
				vm.setBalance(rs.getFloat("Balance"));
				vm.setCustomerId(rs.getInt("CustomerId"));
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
