package edu.kh.jsp.student.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static edu.kh.jsp.common.JDBCTemplate.*;
import edu.kh.jsp.student.model.dto.Student;

public class StudentDAO {
  
	 private Statement stmt;
	 private PreparedStatement pstmt;
	 private ResultSet rs;
	 private Properties prop;
	 
	 
	  public StudentDAO() {
	   
		   try {
			   
			  prop = new Properties();
			   
			  String filePath = StudentDAO.class.getResource("/edu/kh/jsp/sql/student-sql.xml").getPath();
			  
			   
			   
			   prop.loadFromXML(new FileInputStream(filePath));
			   
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		  
		  
	  }


	public List<Student> selectAll(Connection conn) throws Exception{
		
		List<Student> stdList = new ArrayList<Student>();
		
		try {
			
			String sql = prop.getProperty("selectAll");
			
	        stmt = conn.createStatement();
	        
	        rs = stmt.executeQuery(sql);
	        
	        while(rs.next()) {
	        	
	        	String no = rs.getString("STUDENT_NO");
	        	String name = rs.getString("STUDENT_NAME");
	        	String address = rs.getString("STUDENT_ADDRESS");
	        	String depName = rs.getString("DEPARTMENT_NAME");
	        	
	        	Student st = new Student(no,name,address,depName);
	        	
	        	stdList.add(st);
	        	
	        }
			
			
			
		}finally {
			
			close(rs);
			close(stmt);
			
		}
		
		
		return stdList;
	}


	public List<Student> selectArch(Connection conn) throws Exception{
		
		List<Student> list = new ArrayList<Student>();
		
		try {
			
			String sql = prop.getProperty("selectArch");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String no = rs.getString("STUDENT_NO");
				String name = rs.getString("STUDENT_NAME");
				String departname = rs.getString("DEPARTMENT_NAME");
				String address = rs.getString("STUDENT_ADDRESS");
				
				//학번 이름 주소 학과
				
				Student st = new Student(no,name,departname,address);
				
				list.add(st);
				
				
				
				
			}
			
		}finally {
			
			close(rs);
			close(stmt);
			
		}
		
		
		return list;
	}


	public List<Student> selectOne(Connection conn, String deptName) throws Exception{
		
List<Student> list = new ArrayList<Student>();
		
		try {
			
			String sql = prop.getProperty("selectOne");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, deptName);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				String no = rs.getString("STUDENT_NO");
				String name = rs.getString("STUDENT_NAME");
				String departname = rs.getString("DEPARTMENT_NAME");
				String address = rs.getString("STUDENT_ADDRESS");
				
				//학번 이름 주소 학과
				
				Student st = new Student(no,name,departname,address);
				
				list.add(st);
				
				
				
				
			}
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		return list;
		
	}
	  
	   
	 
	 
	
}
