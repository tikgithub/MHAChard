package com.mhacard.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mhacard.model.APIUser;

@Service
public class APIUserServiceImpl {
    @Autowired
    @Qualifier("localJDBCTemplate")
    private JdbcTemplate sqlServer;
    
    public void add(APIUser user)throws Exception{
    	Connection con = null;
    	PreparedStatement pre = null;
    	try {
			con = sqlServer.getDataSource().getConnection();
    		pre = con.prepareStatement("insert into APIUser (email, password) values (?, ?)");
    		pre.setString(1, user.getEmail());
    		pre.setString(2, user.getPassword());
    		pre.execute();
    		pre.close();
    		con.close();
		} catch (Exception e) {
			pre.close();
			con.close();
			throw new Exception(e);
		}
    }
    
    public void update(APIUser user)throws Exception{
    	Connection con = null;
    	PreparedStatement pre = null;
    	try {
			con = sqlServer.getDataSource().getConnection();
    		pre = con.prepareStatement("Update APIUser set password=? where email=?");
    		pre.setString(2, user.getEmail());
    		pre.setString(1, user.getPassword());
    		pre.execute();
    		pre.close();
    		con.close();
		} catch (Exception e) {
			pre.close();
			con.close();
			throw new Exception(e);
		}
    }
    
    public void delete(String email)throws Exception{
    	Connection con = null;
    	PreparedStatement pre = null;
    	try {
			con = sqlServer.getDataSource().getConnection();
    		pre = con.prepareStatement("delete from APIUser where email=?");
    		pre.setString(1, email);
    		pre.execute();
    		pre.close();
    		con.close();
		} catch (Exception e) {
			pre.close();
			con.close();
			throw new Exception(e);
		}
    }
    
    public List<APIUser> getAll() throws Exception{
    	Connection con = null;
    	PreparedStatement pre = null;
    	try {
			con = sqlServer.getDataSource().getConnection();
    		pre = con.prepareStatement("select email from APIUser");
    		ResultSet rs = pre.executeQuery();
    		List<APIUser> listUser = new ArrayList<APIUser>();
    		APIUser user = null;
    		while(rs.next()) {
    			user = new APIUser();
    			user.setEmail(rs.getString("email"));
    			listUser.add(user);
    		}
    		pre.close();
    		con.close();
    		return listUser;
    		
		} catch (Exception e) {
			pre.close();
			con.close();
			throw new Exception(e);
		}
    }
    
    public APIUser getByEmail(String email) throws Exception{
    	Connection con = null;
    	PreparedStatement pre = null;
    	try {
			con = sqlServer.getDataSource().getConnection();
			pre = con.prepareStatement("select email from APIUser where email=?");
			pre.setString(1, email);
			ResultSet rs = pre.executeQuery();
			APIUser user = null;
			while(rs.next()) {
				user = new APIUser();
				user.setEmail(rs.getString("email"));
				user.setPassword(null);
			}
			pre.close();
			con.close();
			return user;
			
		} catch (Exception e) {
			pre.close();
			con.close();
			throw new Exception(e);
		}
    }
    
}
