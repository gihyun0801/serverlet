package edu.kh.todoList.todo.model.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.toList.todo.model.dto.Todo;
import edu.kh.todoList.common.JDBCTemplate;
import edu.kh.todoList.todo.model.dao.TodoDAO;

public class TodoService {

	private TodoDAO dao = new TodoDAO();
	
	
	public List<Todo> selectAll(int memberNo) throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<Todo> list = dao.selectAll(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

}
