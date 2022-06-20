package com.mhacard.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mhacard.model.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl {
	@Autowired
	@Qualifier("localJDBCTemplate")
	JdbcTemplate localDBSource;

	public long add(Document doc) throws Exception {
		String sql = "insert into document(doc_number,doc_date,print_total,add_date,add_by,print_status) values (?,?,?,getdate(),?,?)";
		KeyHolder key = new GeneratedKeyHolder();

		localDBSource.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, doc.getDocNumber());
				ps.setDate(2, new java.sql.Date(doc.getDocDate().getTime()));
				ps.setInt(3, doc.getPrintTotal());
				ps.setString(4, doc.getAddBy());
				ps.setString(5, doc.getPrintStatus());
				return ps;
			}

		}, key);

		return key.getKey().longValue();
	}

	public boolean isDocumentIssue(String docNo) throws Exception {
		String sql = "select doc_number from Document where doc_number = ?";
		Connection con = localDBSource.getDataSource().getConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, docNo);
		ResultSet rs = pre.executeQuery();

		boolean isExist = false;
		if (rs.next()) {
			isExist = true;
		}
		pre.close();
		con.close();
		return isExist;

	}

	public List<Document> getPrintingListFromLocalDB() throws Exception {
		String sql = "select * from document";
		Connection con = localDBSource.getDataSource().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Document> listDocs = new ArrayList<>();
		Document doc = null;
		while (rs.next()) {
			doc = new Document();
			doc.setId(rs.getInt("id"));
			doc.setDocNumber(rs.getString("doc_number"));
			doc.setDocDate(rs.getDate("doc_date"));
			doc.setPrintTotal(rs.getInt("print_total"));
			doc.setAddDate(rs.getDate("add_date"));
			doc.setAddBy(rs.getString("add_by"));
			doc.setPrintStatus(rs.getString("print_status"));
			listDocs.add(doc);
		}
		ps.close();
		con.close();
		return listDocs;
	}

	public Document getById(long id) throws Exception {
		String sql = "select * from document where id=?";
		Connection con = localDBSource.getDataSource().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, id);
		Document doc = null;
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			doc = new Document();
			doc.setId(rs.getInt("id"));
			doc.setDocNumber(rs.getString("doc_number"));
			doc.setDocDate(rs.getDate("doc_date"));
			doc.setPrintTotal(rs.getInt("print_total"));
			doc.setAddDate(rs.getDate("add_date"));
			doc.setAddBy(rs.getString("add_by"));
			doc.setPrintStatus(rs.getString("print_status"));
		}
		ps.close();
		con.close();
		return doc;
	}
}
