package ex22102526;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/22102526delete")
public class Ex11DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		
		Ex05MemberDAO dao=new Ex06MemberDAOImpl();
		if(dao.delete(id)==0) {
			//�����ȵ� -> �޼��� ����, ������������ �Ѿ
			request.setAttribute("errMsg", id+"������ ������ �� �����ϴ�");
			request.getRequestDispatcher("SelfStudy/22102526/03_error.jsp").forward(request, response);
		}else {
			//������ -> �ٽ� �˻��Ϸ�
			response.sendRedirect("22102526selectAll");//�����Ǿ� �������Ű� ���� response��
		}
	}//service��

}
