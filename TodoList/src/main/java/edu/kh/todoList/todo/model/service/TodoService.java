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


	/** Todo 등록하기 서비스
	 * @param title
	 * @param memo
	 * @param memberNo
	 * @return
	 */
	public int insert(String title, String memo, int memberNo) throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.insert(conn,title,memo,memberNo);
		
		if(result > 0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		
		
		return result;
	}


	public int delete(String todoNo) throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.delete(conn, todoNo);
		
		if(result > 0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		
		return result;
	}


	public int update(String no, String title, String memo) throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.update(conn, no, title, memo);
		
		
		if(result > 0) JDBCTemplate.commit(conn);
		else    JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		
		return result;
	}


	/** Todo 조회 서비스
	 * @param todoNo
	 * @param memberNo
	 * @return
	 */
	public Todo selectOne(String todoNo, int memberNo) throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();
		
		Todo todo = dao.selectOne(conn, todoNo, memberNo);
		
		JDBCTemplate.close(conn);
		
		return todo;
	}

}
