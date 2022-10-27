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
		Ex05MemberDAO dao=new Ex06MemberDAOImpl(); //DAO로 넘기기위해 호출
		List<Ex04Member> list=dao.selectAll(); //List에 DTO담기
		
		//list를 scope영역에 저장
		request.setAttribute("memberList", list); //키,밸류 저장 -> 뷰에서 키 : ${memberList} 호출
		
		//memberSelect.jsp로 이동한다.
		request.getRequestDispatcher("memberSelect.jsp").forward(request, response);
	}

}
