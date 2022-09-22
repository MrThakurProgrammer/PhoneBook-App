package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entities.Contact;
import entities.User;

public class userDao {

	private Connection con;

	public userDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean userRegister(User user)
	{
		boolean f=false;
		try {
			String sql="insert into user(name,email,password) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			
			ps.executeUpdate();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}		
		return true;
	}
	
	public User loginUser(String email, String password){
		User user=null;
		try {
			String sql="select * from user where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
			}
		}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		return user;
	}	
}
