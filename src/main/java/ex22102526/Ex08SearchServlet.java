package ex22102526;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/22102526search")
public class Ex08SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyField=request.getParameter("keyField");
		String keyWord=request.getParameter("keyWord");
		
		Ex05MemberDAO dao=new Ex06MemberDAOImpl();
		List<Ex04Member> list=dao.searchByKeyWord(keyField, keyWord);
		
		request.setAttribute("memberList", list);
		request.getRequestDispatcher("memberSelect.jsp").forward(request, response);
	}

}
