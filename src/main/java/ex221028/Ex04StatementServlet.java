package ex221028;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.SecurityDao;

/**
 * Servlet implementation class StatementServlet
 */
@WebServlet("/221028selectState")
public class Ex04StatementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empno = request.getParameter("empno");//
		
		Ex02SecurityDao dao= new Ex02SecurityDao();
		List<String> list = dao.statementSelect(empno);
		
		System.out.println("statement °³¼ö : " +  list.size());
		
		
	}

}








