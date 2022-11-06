package ex22110234;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * ȸ�������� ���� Controller
 */
public class Ex05UserController implements Ex03Controller {

	@Override
	public Ex06ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		
		return null;
	}
	/**
	 * �α���
	 */
	public Ex06ModelAndView login(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("UserController�� login");
		// service->daoȣ��
		
		//�α��� �����ϸ� ���ǿ� ���� ���� 
		//session�� redirect�ΰ����(�����������ִµ��� �����Ǵϱ�)
		HttpSession session=request.getSession();
		session.setAttribute("sessionMessage", "�α��ε� �����Դϴ�");
		
		return new Ex06ModelAndView("22110234/02_login.jsp",true);//redirect������� �̵��Ѵ�.
	}
	
	/**
	 * ȸ����������
	 */
	public Ex06ModelAndView update(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("UserController�� update");
		// ����ȣ��->dao
		//request�����̴ϱ� forward�̵�
		request.setAttribute("message", "�����Ϸ�Ǿ����ϴ�");
		
		return new Ex06ModelAndView("22110234/03_update.jsp"); //forward������� �̵�����.
	}
	
	/**
	 * �����ϱ�
	 */
	
	/**
	 * �α׾ƿ�
	 */

}
