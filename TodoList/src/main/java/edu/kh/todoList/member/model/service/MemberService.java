package edu.kh.todoList.member.model.service;

import edu.kh.toList.member.model.dto.Member;
import static edu.kh.todoList.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.todoList.member.model.dao.MemberDAO;

public class MemberService {
 
	 
	private MemberDAO dao = new MemberDAO();

	public Member login(String inputId, String inputPw) throws Exception{
		
		Connection conn = getConnection();
		
		Member loginMember = dao.login(inputId, inputPw,conn);
		
		close(conn);
		
		
		return loginMember;
	}
	
	
	 
	 
	 
	
}
