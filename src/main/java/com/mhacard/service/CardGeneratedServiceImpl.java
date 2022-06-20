package com.mhacard.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mhacard.model.QueryForCard;
import com.mhacard.model.QueryForCardResponse;
@Service
public class CardGeneratedServiceImpl {
    @Autowired
    @Qualifier("LVBSwitchJDBCTemplate")
    JdbcTemplate cardGeneratedJDBC;

    public QueryForCardResponse getCardGenerated(QueryForCard info) throws Exception{
        String sql = 
        "SELECT a.CARD_NO,a.ACC_NO," +
        "(d.F_NAME || ' '|| d.L_NAME) PREFERRED_NAME,a.PRODUCT_TYPE,a.CARD_STATUS  FROM CARD_MASTER_WK "+
        " a   INNER JOIN CUSTOMER_MASTER c "+
        " ON a.CIN = c.CIN INNER JOIN CUSTOMER_MASTER_WK d ON a.CIN = d.CIN " +
        " Where d.f_name =? and d.l_name=? and d.gender = ? and a.acc_no=? ";

        Connection con = cardGeneratedJDBC.getDataSource().getConnection();
		PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1, info.getF_name());
        pre.setString(2, info.getL_name());
        pre.setString(3, info.getGender());
        pre.setString(4, info.getAcc_no());

        ResultSet rs = pre.executeQuery();
        QueryForCardResponse cardData = null;
        while(rs.next()){
            cardData = new QueryForCardResponse();
            cardData.setCard_no(rs.getString("CARD_NO"));
            cardData.setAcc_no(rs.getString("ACC_NO"));
            cardData.setPrefered_name(rs.getString("PREFERRED_NAME"));
            cardData.setProduct_type(rs.getString("PRODUCT_TYPE"));
            cardData.setCard_status(rs.getString("CARD_STATUS"));
        }
        con.close();
        pre.close();
        return cardData;
    }
}
