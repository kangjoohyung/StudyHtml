package ex22102526;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ReadServlet
 */
@WebServlet("/22102526read")
public class Ex09ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="SelfStudy/22102526/03_error.jsp";
		
		//�Ѿ���� id�� �ޱ�
		String id = request.getParameter("id");
		Ex05MemberDAO dao = new Ex06MemberDAOImpl();
		Ex04Member member = dao.selectById(id);
		
		if(member==null) {
			request.setAttribute("errMsg", id+"�� �ش��ϴ� ������ �����ϴ�.");
		}else {
			request.setAttribute("member", member);//read.jsp���� ${member.�Ӽ�}
			url="read.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}//serviceEnd

}










