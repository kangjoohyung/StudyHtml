package ex22110234;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �Խ��ǿ� ���õ� Controller
 *
 */
public class Ex08BoardController implements Ex03Controller {

	@Override
	public Ex06ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * �Խù� �˻�
	 */
	public Ex06ModelAndView list(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("BoardController�� list");
		
		request.setAttribute("message", "�˻�����Դϴ�");
		return new Ex06ModelAndView("22110234/06_list.jsp");
	}
	
	/**
	 * �󼼺���
	 */
	public Ex06ModelAndView read(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("BoardController�� read");
		
		return new Ex06ModelAndView("22110234/07read.jsp", true);
	}
}
