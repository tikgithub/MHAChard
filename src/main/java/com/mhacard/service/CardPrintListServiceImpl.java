package com.mhacard.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mhacard.model.CardPrintingList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

@Service
public class CardPrintListServiceImpl {
    @Autowired
    @Qualifier("localJDBCTemplate")
    private JdbcTemplate localJDBCTEmplate;

    public long add(CardPrintingList card){
        String sql = 
        "insert into PrintingList " +
        "(issue_by,issue_date,account_number, account_name,atm_number,social_card_number,idEmployee,lafname, lalname,enfname, enlname,sex, dob,datepermanent, note,photo,doc_id)" + 
        " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        KeyHolder key  = new GeneratedKeyHolder();

         localJDBCTEmplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, card.getIssue_by());
                ps.setDate(2, new java.sql.Date(card.getIssue_date().getTime()));
                ps.setString(3, card.getAccount_number());
                ps.setString(4, card.getAccount_name());
                ps.setString(5, card.getAtm_number());
                ps.setString(6, card.getSocial_card_number());
                ps.setString(7, card.getIdEmployee());
                ps.setString(8, card.getLaFName());
                ps.setString(9, card.getLaLName());
                ps.setString(10, card.getEnFName());
                ps.setString(11, card.getEnLname());
                ps.setString(12, card.getSex());
                ps.setDate(13, new java.sql.Date(card.getDob().getTime()));
                ps.setDate(14, new java.sql.Date(card.getDatePermanent().getTime()));
                ps.setString(15, card.getNote());
                ps.setString(16,card.getPhoto());
                ps.setLong(17,card.getDoc_id());
                return ps;
            }
            
        }, key);

            return key.getKey().longValue();
    }

    public List<CardPrintingList> getPrintingListByDocId(long doc_id) throws Exception{
    	String sql = "select * from PrintingList where doc_id=?";
    	Connection con = localJDBCTEmplate.getDataSource().getConnection();
		PreparedStatement pre = con.prepareStatement(sql);
    	pre.setLong(1, doc_id);
    	
    	List<CardPrintingList> listPrints = new ArrayList<CardPrintingList>();
    	
    	ResultSet rs = pre.executeQuery();
    	
    	CardPrintingList print = null;
    	
    	while(rs.next()) {
    		print = new CardPrintingList();
    		
    		print.setIssue_by(rs.getString("issue_by"));
    		print.setIssue_date(rs.getDate("issue_date"));
    		print.setNote(rs.getString("note"));
    		print.setAccount_number(rs.getString("account_number"));
    		print.setAccount_name(rs.getString("account_name"));
    		print.setAtm_number(rs.getString("atm_number"));
    		print.setSocial_card_number(rs.getString("social_card_number"));
    		print.setIdEmployee(rs.getString("idEmployee"));
    		print.setLaFName(rs.getString("LaFName"));
    		print.setLaLName(rs.getString("LaLName"));
    		print.setEnFName(rs.getString("EnFName"));
    		print.setEnLname(rs.getString("EnLName"));
    		print.setSex(rs.getString("sex"));
    		print.setDob(rs.getDate("DOB"));
    		print.setPhoto(rs.getString("photo"));
    		print.setDatePermanent(rs.getDate("datePermanent"));
    		print.setDoc_id(rs.getLong("doc_id"));
    		print.setPrint_status(rs.getString("card_status"));
    		print.setId(rs.getLong("id"));
    		
    		listPrints.add(print);
    		
    	}
    	pre.close();
    	con.close();
    
    	
    	return listPrints;
    	
    }
    
    public void updatePrintingStatus(long id, String status) throws Exception{
    	Connection con = null;
    	PreparedStatement pre= null;
    	try {
    		String sql = "Update PrintingList set card_status = ? Where id=?";
    		con = localJDBCTEmplate.getDataSource().getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, status);
			pre.setLong(2, id);
			pre.execute();
			
    		con.close();
			pre.close();
		} catch (Exception e) {
			con.close();
			throw new Exception(e);
		}
    }
    
    public CardPrintingList getDataById(long id) throws Exception{
    	Connection con = null;
    	PreparedStatement pre = null;
    	try {
    		con = localJDBCTEmplate.getDataSource().getConnection();
    		
			String sql = "select * from printinglist where id=?";
			pre = con.prepareStatement(sql);
			pre.setLong(1, id);
			CardPrintingList data = null;
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				data = new CardPrintingList();
				data.setIssue_by(rs.getString("issue_by"));
				data.setIssue_date(rs.getDate("issue_date"));
				data.setNote(rs.getString("note"));
				data.setAccount_number(rs.getString("account_number"));
				data.setAccount_name(rs.getString("account_name"));
				data.setAtm_number(rs.getString("atm_number"));
				data.setSocial_card_number(rs.getString("social_card_number"));
				data.setIdEmployee(rs.getString("idEmployee"));
				data.setLaFName(rs.getString("LaFName"));
				data.setLaLName(rs.getString("LaLName"));
	    		data.setEnFName(rs.getString("EnFName"));
	    		data.setEnLname(rs.getString("EnLName"));
	    		data.setSex(rs.getString("sex"));
	    		data.setDob(rs.getDate("DOB"));
	    		data.setPhoto(rs.getString("photo"));
	    		data.setDatePermanent(rs.getDate("datePermanent"));
	    		data.setDoc_id(rs.getLong("doc_id"));
	    		data.setPrint_status(rs.getString("card_status"));
	    		data.setId(rs.getLong("id"));
			}
    		con.close();
    		pre.close();
    		return data;
		} catch (Exception e) {
			con.close();
			pre.close();
			throw new Exception(e);
		}
    }
    
}
