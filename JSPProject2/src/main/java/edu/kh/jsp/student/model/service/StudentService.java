package edu.kh.jsp.student.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.jsp.common.JDBCTemplate.*;
import edu.kh.jsp.student.model.dao.StudentDAO;
import edu.kh.jsp.student.model.dto.Student;

public class StudentService {
  private StudentDAO dao = new StudentDAO();
  

/** 학생 전체 조회 서비스
 * @return
 */
public List<Student> selectAll() throws Exception{
	
   Connection conn = getConnection();	
   
   List<Student> stdList = dao.selectAll(conn);
   
   if(stdList != null) close(conn); 
	
	return stdList;
}


public List<Student> selectArch() throws Exception{
	
	Connection conn = getConnection();
	
	List<Student> list = dao.selectArch(conn);
	
	if(list != null) close(conn);
	
	
	return list;
}


public List<Student> selectOne(String deptName) throws Exception{
	
Connection conn = getConnection();
	
	List<Student> list = dao.selectOne(conn, deptName);
	
	if(list != null) close(conn);
	return list;
}
  
  
}
