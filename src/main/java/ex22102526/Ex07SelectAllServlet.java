package ex22102526;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SelectAllServlet
 */
@WebServlet("/22102526selectAll")
public class Ex07SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ex05MemberDAO dao=new Ex06MemberDAOImpl(); //DAO�� �ѱ������ ȣ��
		List<Ex04Member> list=dao.selectAll(); //List�� DTO���
		
		//list�� scope������ ����
		request.setAttribute("memberList", list); //Ű,��� ���� -> �信�� Ű : ${memberList} ȣ��
		
		//memberSelect.jsp�� �̵��Ѵ�.
		request.getRequestDispatcher("memberSelect.jsp").forward(request, response);
	}

}
