package org.studyeasy.spring.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.studyeasy.spring.model.User;

public class AppDAOImpl implements AppDAO {
	
	private DataSource dataSource;

	public AppDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<User> listUsers() {
		List<User> listUsers=new ArrayList();
		Connection conn=null;
		String sql="select * from users";
		try {
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				User temp=new User(rs.getInt("userId"),rs.getString("name"),rs.getString("email"));
				listUsers.add(temp);
				
			}
			rs.close();
			ps.close();
			System.out.print(listUsers);
			return listUsers;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	

}
