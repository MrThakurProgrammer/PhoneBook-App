package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Contact;

public class contactDao {
	
	private Connection con;

	public contactDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean saveContact(Contact contact)
	{
		boolean f=false;
		try {
			String sql="insert into contact(name,email,phoneno,about,userid) values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getEmail());
			ps.setString(3, contact.getPhno());
			ps.setString(4, contact.getAbout());
			ps.setInt(5, contact.getUserId());
			
			int i=ps.executeUpdate();
			if(i==1) {
				//System.out.println("done.........");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return true;
	}
	
	public List<Contact> getAllContact(int uid)	{
			List<Contact> list=new ArrayList();
			Contact c=null;
			
			try{
				String sql="select * from contact where userid=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1,uid);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					c=new Contact();
					c.setId(rs.getInt(1));
					c.setName(rs.getString(2));
					c.setEmail(rs.getString(3));
					c.setPhno(rs.getString(4));
					c.setAbout(rs.getString(5));
					
					list.add(c);
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return list;
	}
	
	public Contact getContactById(int cid){
		Contact contact=new Contact();
		
		try {
				PreparedStatement ps=con.prepareStatement("select * from contact where id=?");
				ps.setInt(1, cid);
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					contact.setId(rs.getInt(1));
					contact.setName(rs.getString(2));
					contact.setEmail(rs.getString(3));
					contact.setPhno(rs.getString(4));
					contact.setAbout(rs.getString(5));
				}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return contact;
	}
	
	public boolean updateContact(Contact contact)
	{
		boolean f=false;
		try {
			
			String sql="update contact set name=?, email=?, phoneno=?, about=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getEmail());
			ps.setString(3, contact.getPhno());
			ps.setString(4, contact.getAbout());
			ps.setInt(5, contact.getId());
			
			int i=ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return f;
	}
		
	public boolean deleteContact(int id) {
		boolean f=false;
		
		try {
			String sql="delete from contact where id=?";
			PreparedStatement ps=con.prepareStatement(sql);			
			ps.setInt(1, id);
			
			int i=ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
