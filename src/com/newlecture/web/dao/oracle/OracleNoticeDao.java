package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;

public class OracleNoticeDao implements NoticeDao {

	@Override
	public List<NoticeView> getList() throws ClassNotFoundException, SQLException {
		return getList(1, "title","");
	}
	
	@Override
	public List<NoticeView> getList(int page) throws ClassNotFoundException, SQLException {
		return getList(page, "title","");
	}
	
	@Override
	public List<NoticeView> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		
		List<NoticeView> list = new ArrayList<>();
		
		int start = 1+(page-1)*10;  // 1, 11, 21, 31, 41,...
		int end = page*10;   // 10, 20, 30, 40, 50
		
		String sql = "SELECT * FROM NOTICE_VIEW " + 
				"WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		PreparedStatement st  = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%"); 
		st.setInt(2,  start);
		st.setInt(3,  end);		
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			NoticeView notice = new NoticeView(
							rs.getInt("id"),
							rs.getString("title"),
							"",
							rs.getString("writer_id"),
							rs.getDate("regdate"),
							rs.getInt("hit"),
							rs.getInt("comment_count")
						);
			
			list.add(notice);			
		}	
		
		rs.close();
		st.close();
		con.close();	
		
		return list;
	}

	@Override
	public Notice get(int id) throws ClassNotFoundException, SQLException {		
		Notice notice = null;
		
		String sql = "select * from NOTICE where id="+id;
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		Statement st  = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
			notice = new Notice(
							rs.getInt("id"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getString("writer_id"),
							rs.getDate("regdate"),
							rs.getInt("hit")
						);	
			
		}	
		
		rs.close();
		st.close();
		con.close();	
		
		return notice;
	}

	@Override
	public Notice getPrev(int id)  throws ClassNotFoundException, SQLException{
		Notice notice = null;
		
		String sql = "SELECT * FROM (SELECT * FROM NOTICE_VIEW ORDER BY REGDATE DESC) " + 
				"WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID = "+id+") " + 
				"AND ROWNUM = 1";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		Statement st  = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
			notice = new Notice(
					rs.getInt("id"),
					rs.getString("title"),
					"",
					rs.getString("writer_id"),
					rs.getDate("regdate"),
					rs.getInt("hit")
				);			
		}
		
		rs.close();
		st.close();
		con.close();	
		
		return notice;
	}

	@Override
	public Notice getNext(int id)  throws ClassNotFoundException, SQLException{
		
		Notice notice = null;
		
		String sql = "SELECT * FROM (SELECT * FROM NOTICE_VIEW ORDER BY REGDATE) " + 
				"WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID = "+id+") " + 
				"AND ROWNUM = 1";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		Statement st  = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
			notice = new Notice(
					rs.getInt("id"),
					rs.getString("title"),
					"",
					rs.getString("writer_id"),
					rs.getDate("regdate"),
					rs.getInt("hit")
				);	
			
		}	
		
		rs.close();
		st.close();
		con.close();	
		
		return notice;
	}

	@Override
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
		String sql = "INSERT INTO NOTICE(ID,TITLE,CONTENT,WRITER_ID) "
				+ "VALUES(NOTICE_SEQ.NEXTVAL,?,?,'newlec')";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
			
		PreparedStatement st  = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	@Override
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		String sql = "UPDATE NOTICE SET TITLE=?, CONTENT=? WHERE ID=?";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		
		PreparedStatement st  = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		st.setInt(3, notice.getId());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		String sql = "DELETE NOTICE WHERE ID=?";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		
		PreparedStatement st  = con.prepareStatement(sql);		
		st.setInt(1, id);
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

}
