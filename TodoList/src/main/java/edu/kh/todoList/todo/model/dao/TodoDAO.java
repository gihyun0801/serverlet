package edu.kh.todoList.todo.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.toList.todo.model.dto.Todo;
import edu.kh.todoList.common.JDBCTemplate;
import edu.kh.todoList.member.model.dao.MemberDAO;

public class TodoDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	
	public TodoDAO() {
		 try {
			 
			 
			 prop = new Properties();
			 
			 String filePath = MemberDAO.class.getResource("/edu/kh/todoList/sql/todo-sql.xml").getPath();
			 
			 
			 prop.loadFromXML(new FileInputStream(filePath));
			 
			 
			 
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }


	public List<Todo> selectAll(Connection conn, int memberNo) throws Exception{
		
		List<Todo> list = new ArrayList<Todo>();
		
		try {
			
			String sql = prop.getProperty("selectAll");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int no = rs.getInt("TODO_NO");
				String title = rs.getString("TODO_TITLE");
				String meno = rs.getString("TODO_MEMO");
				String date = rs.getString("TODO_DATE");
				
				Todo to = new Todo();
				
				to.setTodoNo(rs.getInt(1));
				to.setTodoTitle(rs.getString(2));
				to.setTodoMemo(rs.getString(3));
				to.setTodoDate(rs.getString(4));
				
				list.add(to);
				
			}
			
			
			
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
}
