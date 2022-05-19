package com.mhacard.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
        "(issue_by,issue_date,account_number, account_name,atm_number,social_card_number,idEmployee,lafname, lalname,enfname, enlname,sex, dob,datepermanent, note)" + 
        " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
                return ps;
            }
            
        }, key);

            return key.getKey().longValue();
    }
}
